package com.example.bazar.controllers;
import com.example.bazar.models.Producto;
import com.example.bazar.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PostMapping("/guardar")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "Producto creado exitosamente.";
    }

    @GetMapping("/traer")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("/traer/{codigo_producto}")
    public Producto getProductoById(@PathVariable Long codigo_producto){
        return productoService.getProductobyId(codigo_producto);
    }

    @DeleteMapping("/borrar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){

        if(this.getProductoById(codigo_producto) != null){
            productoService.deleteProducto(codigo_producto);
            return "Producto eliminado exitosamente.";
        }else {
            return "Producto no encontrado.";
        }
    }

    @PutMapping("/editar")
    public String editProducto(@RequestBody Producto producto){
        productoService.editProducto(producto);
        return "Se ha editado exitosamente.";
    }

    @GetMapping("/falta_stock")
    public List<Producto> falta_stock(){
        return productoService.falta_stock();
    }
}
