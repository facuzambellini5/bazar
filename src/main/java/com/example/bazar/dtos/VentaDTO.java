package com.example.bazar.dtos;

import java.time.LocalDate;
import java.util.List;

public class VentaDTO {

    private LocalDate fecha_venta;
    private List<VentaProductoDTO> productos;
    private Long id_cliente;


    public VentaDTO() {
    }

    public VentaDTO(LocalDate fecha_venta, List<VentaProductoDTO> productos, Long id_cliente) {
        this.fecha_venta = fecha_venta;
        this.productos = productos;
        this.id_cliente = id_cliente;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public List<VentaProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<VentaProductoDTO> productos) {
        this.productos = productos;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
}