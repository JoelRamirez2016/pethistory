/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.DetalleHCModel;
import com.tucompra.pethistory.services.DetalleHCService;
import com.tucompra.pethistory.services.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Holberton
 */

@RestController
@RequestMapping
public class DetalleHCController {
    @Autowired
    HistoriaClinicaService hcService;
    @Autowired
    DetalleHCService detallesHcService;

    @GetMapping("/hc/{hcId}/detalles")
    public ArrayList<DetalleHCModel> obtenerDetallesByHistoriaClinica(
            @PathVariable (value = "hcId") Long hcId){
        return detallesHcService.obtenerDetallesByHistoriaClinica(hcId);
    }

    @PostMapping("/hc/{hcId}/detalles")
    public DetalleHCModel guardarDetallesHC(
            @PathVariable (value = "hcId") Long hcId,
            @RequestBody DetalleHCModel detalle){
        return this.hcService.obtenerPorId(hcId).map(hc -> {
            detalle.setHistoria_clinica(hc);
            return this.detallesHcService.guardarDetalles(detalle);
        }).orElseThrow(() -> new RuntimeException("Resource Not Found"));
    }
    
    @PutMapping("/hc/{hcId}/detalles/{detalleId}")
    public DetalleHCModel actualizarDetallesHC(
        @PathVariable (value = "hcId") Long hcId, 
        @PathVariable (value = "hcId") Long detalleId, 
        @RequestBody DetalleHCModel detalle){

        if(this.hcService.obtenerPorId(hcId) == null) {
            throw new RuntimeException("historia clinica " + hcId + " not found");
        }
        if(this.detallesHcService.obtenerPorId(hcId) == null) {
            throw new RuntimeException("detalle " + hcId + " not found");
        }
        return this.detallesHcService.guardarDetalles(detalle);
    }
    
    @GetMapping("detalles/{id}")
    public Optional<DetalleHCModel> obtenerDetallesHCById(
        @PathVariable("id") Long id) {
        return this.detallesHcService.obtenerPorId(id);
    }
    
    @DeleteMapping("detalles/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        try{
            this.hcService.eliminarHistoriaClinica(id);
            return "Se eliminó el detalle  " + id;
        }catch(Exception err){
            return "No se pudo eliminar el detalle " + id;
        }
    }
    
}

