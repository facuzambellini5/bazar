package com.example.bazar.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class VentaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id_ventaProducto;

    @ManyToOne
    @JoinColumn(name = "codigo_venta")
    @JsonIgnore
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

    private int cantidad;

    public VentaProducto() {
    }

    public VentaProducto(Long id_ventaProducto, Venta venta, Producto producto, int cantidad) {
        this.id_ventaProducto = id_ventaProducto;
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Long getId_ventaProducto() {
        return id_ventaProducto;
    }

    public void setId_ventaProducto(Long id_ventaProducto) {
        this.id_ventaProducto = id_ventaProducto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
