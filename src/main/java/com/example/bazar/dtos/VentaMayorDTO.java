package com.example.bazar.dtos;

import com.example.bazar.models.VentaProducto;

import java.util.List;

public class VentaMayorDTO {

    private Long codigo_venta;
    private Double total;
    private List<VentaProducto> listaProductos;
    private String nombre;
    private String apellido;

    public VentaMayorDTO() {
    }

    public VentaMayorDTO(Long codigo_venta, Double total, List<VentaProducto> listaProductos, String nombre, String apellido) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<VentaProducto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<VentaProducto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
