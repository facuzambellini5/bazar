package com.example.bazar.services;
import com.example.bazar.models.Producto;

import java.util.List;

public interface IProductoService {

    public abstract void saveProducto(Producto producto);

    public abstract List<Producto> getProductos();

    public abstract Producto getProductobyId(Long codigo_producto);

    public abstract void deleteProducto(Long codigo_producto);

    public abstract void editProducto(Producto producto);

    //public abstract void actualizarStock(Long codigo_producto, int cantidad);

    public abstract List<Producto> falta_stock();
}
