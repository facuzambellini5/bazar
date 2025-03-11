package com.example.bazar.controllers;

import com.example.bazar.dtos.VentaDTO;
import com.example.bazar.models.Venta;
import com.example.bazar.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    IVentaService ventaService;


    @PostMapping("/guardar")
    public String saveVenta(@RequestBody VentaDTO ventaDTO){
        ventaService.saveVenta(ventaDTO);
        return "Venta creada exitosamente";
    }

    @GetMapping("/traer")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("/traer/{codigo_venta}")
    public Venta getVentaById(@PathVariable Long codigo_venta){
        return ventaService.getVentabyId(codigo_venta);
    }

    @DeleteMapping("/borrar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){

        if(this.getVentaById(codigo_venta) != null){
            ventaService.deleteVenta(codigo_venta);
            return "Venta eliminada exitosamente.";
        }else{
            return "Venta no encontrada.";
        }
    }

    @PutMapping("/editar")
    public String editVenta(@RequestBody Venta venta){
        ventaService.editVenta(venta);
        return "Se ha editado exitosamente.";
    }

}
