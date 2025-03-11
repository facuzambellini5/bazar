package com.example.bazar.services;

import com.example.bazar.models.Producto;
import com.example.bazar.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository productoRepo;

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto getProductobyId(Long codigo_producto) {
        return productoRepo.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    /*@Override
    public void actualizarStock(Long codigo_producto, int cantidad){
        Producto producto = this.getProductobyId(codigo_producto);

        producto.setCantidad_disponible(producto.getCantidad_disponible()-cantidad);
        this.saveProducto(producto);
    }
     */

    @Override
    public List<Producto> falta_stock(){

        List<Producto> productosFaltaStock = new ArrayList<>();

        for (Producto producto : productoRepo.findAll()){
            if(producto.getCantidad_disponible() < 5){
                productosFaltaStock.add(producto);
            }
        }
        return productosFaltaStock;
    }

}
