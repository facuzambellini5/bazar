package com.example.bazar.dtos;

import com.example.bazar.models.Venta;

import java.time.LocalDate;
import java.util.List;

public class VentasFechaDTO {

    private LocalDate fecha_venta;
    private int cantidadVentas;
    private Double total;
    private List<Venta> ventas;

    public VentasFechaDTO() {
    }

    public VentasFechaDTO(LocalDate fecha_venta, int cantidadVentas, Double total, List<Venta> ventas) {
        this.fecha_venta = fecha_venta;
        this.cantidadVentas = cantidadVentas;
        this.total = total;
        this.ventas = ventas;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
