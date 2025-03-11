package com.example.bazar.services;

import com.example.bazar.dtos.VentaProductoDTO;
import com.example.bazar.dtos.VentaDTO;
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

        venta.setFecha_venta(ventaDTO.getFecha_venta());

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

            if(producto.getCantidad_disponible() <prodDTO.getCantidad()){
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
}
