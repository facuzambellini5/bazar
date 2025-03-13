package com.example.bazar.services;

import com.example.bazar.dtos.VentaDTO;
import com.example.bazar.dtos.VentaMayorDTO;
import com.example.bazar.dtos.VentasFechaDTO;
import com.example.bazar.models.Venta;
import com.example.bazar.models.VentaProducto;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    public abstract void saveVenta(VentaDTO ventaDto); //Crea una venta pero con un cliente y productos existentes.

    public abstract void saveVenta(Venta venta); //Crea una venta a la vez que crea un nuevo cliente y nuevos productos.

    public abstract List<Venta> getVentas();

    public abstract Venta getVentabyId(Long codigo_venta);

    public abstract void deleteVenta(Long codigo_venta);

    public abstract void editVenta(Venta venta);

    public abstract List<VentaProducto> getProductosVenta(Long codigo_venta);

    public abstract VentasFechaDTO getVentasByFecha(LocalDate fechaVenta);

    public abstract VentasFechaDTO getVentasByFechaBetween(LocalDate fechaInicio, LocalDate fechaFin);

    public abstract VentaMayorDTO getVentaMayor();

}
