package com.example.bazar.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_venta;
    @JsonFormat
    private LocalDate fecha_venta;
    private Double total;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true) //Hace que si se elimina una venta, tambien se eliminan los VentaProducto asociados
    private List<VentaProducto> listaProductos;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente uncliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<VentaProducto> listaProductos, Cliente uncliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.uncliente = uncliente;
    }

    public Long getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
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

    public Cliente getUncliente() {
        return uncliente;
    }

    public void setUncliente(Cliente uncliente) {
        this.uncliente = uncliente;
    }
}