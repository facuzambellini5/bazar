package com.example.bazar.controllers;

import com.example.bazar.dtos.VentaDTO;
import com.example.bazar.dtos.VentaMayorDTO;
import com.example.bazar.dtos.VentasFechaDTO;
import com.example.bazar.models.Venta;
import com.example.bazar.models.VentaProducto;
import com.example.bazar.services.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    IVentaService ventaService;


    @PostMapping("/guardar")
    public String saveVenta(@RequestBody VentaDTO ventaDTO){
        ventaService.saveVenta(ventaDTO);
        return "Venta realizada exitosamente.";
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

    @GetMapping("/productos/{codigo_venta}")
    public List<VentaProducto> getProductosVenta(@PathVariable Long codigo_venta){
        return ventaService.getProductosVenta(codigo_venta);
    }

    @GetMapping("/{fechaVenta}")
    public VentasFechaDTO getVentasByFecha(@PathVariable @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate fechaVenta){
        return ventaService.getVentasByFecha(fechaVenta);
    }

    @GetMapping("/{fechaInicio}/{fechaFin}")
    public VentasFechaDTO getVentasByFechaBetween(@PathVariable @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate fechaInicio,
                                                  @PathVariable @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate fechaFin){
        return ventaService.getVentasByFechaBetween(fechaInicio, fechaFin);
    }

    @GetMapping("/mayor")
    public VentaMayorDTO getVentaMayor(){
        return ventaService.getVentaMayor();
    }

}
