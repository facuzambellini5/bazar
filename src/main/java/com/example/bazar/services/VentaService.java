package com.example.bazar.services;

import com.example.bazar.dtos.VentaMayorDTO;
import com.example.bazar.dtos.VentaProductoDTO;
import com.example.bazar.dtos.VentaDTO;
import com.example.bazar.dtos.VentasFechaDTO;
import com.example.bazar.models.Cliente;
import com.example.bazar.models.Producto;
import com.example.bazar.models.Venta;
import com.example.bazar.models.VentaProducto;
import com.example.bazar.repositories.IClienteRepository;
import com.example.bazar.repositories.IProductoRepository;
import com.example.bazar.repositories.IVentaProductoRepository;
import com.example.bazar.repositories.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class VentaService implements IVentaService{

    @Autowired
    IVentaRepository ventaRepo;

    @Autowired
    IProductoRepository productoRepo;

    @Autowired
    IClienteRepository clienteRepo;

    @Autowired
    IVentaProductoRepository ventaProductoRepo;

    @Override
    public void saveVenta(VentaDTO ventaDTO) {
        Venta venta = new Venta();

        venta.setFechaVenta(ventaDTO.getFecha_venta());

        Cliente cliente = clienteRepo.findById(ventaDTO.getId_cliente()).orElse(null);
        venta.setUncliente(cliente);

        ventaRepo.save(venta);

        List<VentaProducto> ventaProductos = new ArrayList<>();


        Double total = 0.0;

        for(VentaProductoDTO prodDTO : ventaDTO.getProductos()){
            Producto producto = productoRepo.findById(prodDTO.getCodigo_producto()).orElse(null);

            if(producto == null){
                continue;
            }

            if(producto.getCantidad_disponible() < prodDTO.getCantidad()){
                throw new RuntimeException("Stock no disponible para el producto: "+producto.getNombre()+
                                            ". Cantidad disponible: "+producto.getCantidad_disponible());
            }

            producto.setCantidad_disponible(producto.getCantidad_disponible() - prodDTO.getCantidad());
            productoRepo.save(producto);

            VentaProducto ventaProducto = new VentaProducto();

            ventaProducto.setProducto(producto);
            ventaProducto.setCantidad(prodDTO.getCantidad());
            ventaProducto.setVenta(venta);

            ventaProductos.add(ventaProducto);

            total += producto.getCosto() * prodDTO.getCantidad();

            ventaProductoRepo.save(ventaProducto);
        }

        //venta.setListaProductos(ventaProductos);

        venta.setTotal(total);
        ventaRepo.save(venta);
    }

    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta getVentabyId(Long codigo_venta) {
        return ventaRepo.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<VentaProducto> getProductosVenta(Long codigo_venta){
        Venta venta = this.getVentabyId(codigo_venta);

        List<VentaProducto> listaProductos = new ArrayList<>();

        listaProductos.addAll(venta.getListaProductos());

        return listaProductos;
    }

    @Override
    public VentasFechaDTO getVentasByFecha(LocalDate fechaVenta){
        VentasFechaDTO ventasFechaDTO = new VentasFechaDTO();
        ventasFechaDTO.setFecha_venta(fechaVenta);

        List<Venta> ventas = ventaRepo.findByFechaVenta(fechaVenta);

        ventasFechaDTO.setCantidadVentas(ventas.size());

        Double total = 0.0;
        for(Venta venta : ventas){
            total += venta.getTotal();
        }

        ventasFechaDTO.setVentas(ventas);
        ventasFechaDTO.setTotal(total);
        return ventasFechaDTO;
    }

    @Override
    public VentasFechaDTO getVentasByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin){
        VentasFechaDTO ventasFechaDTO = new VentasFechaDTO();
        List<Venta> ventas = ventaRepo.findByFechaVentaBetween(fechaInicio,fechaFin);

        ventasFechaDTO.setCantidadVentas(ventas.size());

        Double total = 0.0;
        for(Venta venta : ventas){
            total += venta.getTotal();
        }

        ventasFechaDTO.setVentas(ventas);
        ventasFechaDTO.setTotal(total);
        return ventasFechaDTO;

    }

    @Override
    public VentaMayorDTO getVentaMayor(){

        Venta venta = ventaRepo.findFirstByOrderByTotalDesc();
        VentaMayorDTO ventaMayorDTO = new VentaMayorDTO();

        ventaMayorDTO.setCodigo_venta(venta.getCodigo_venta());
        ventaMayorDTO.setTotal(venta.getTotal());
        ventaMayorDTO.setListaProductos(venta.getListaProductos());
        ventaMayorDTO.setNombre(venta.getUncliente().getNombre());
        ventaMayorDTO.setApellido(venta.getUncliente().getApellido());

        return ventaMayorDTO;
    }
}
