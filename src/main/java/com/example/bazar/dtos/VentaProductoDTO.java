package com.example.bazar.dtos;

public class VentaProductoDTO {

    private Long codigo_producto;
    private int cantidad;

    public VentaProductoDTO() {
    }

    public VentaProductoDTO(Long codigo_producto, int cantidad) {
        this.codigo_producto = codigo_producto;
        this.cantidad = cantidad;
    }

    public Long getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
