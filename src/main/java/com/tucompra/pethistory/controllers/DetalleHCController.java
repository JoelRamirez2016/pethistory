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
import java.util.Collections;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Holberton
 */
@CrossOrigin(origins="*", maxAge=3200)
@RestController
@RequestMapping
public class DetalleHCController {
    @Autowired
    HistoriaClinicaService hcService;
    @Autowired
    DetalleHCService detallesHcService;

    @GetMapping("/hcs/{hcId}/detalles")
    public ArrayList<DetalleHCModel> obtenerDetallesByHistoriaClinica(
            @PathVariable (value = "hcId") Long hcId){
        return detallesHcService.obtenerDetallesByHistoriaClinica(hcId);
    }

    @PostMapping("/hcs/{hcId}/detalles")
    public DetalleHCModel guardarDetallesHC(
            @PathVariable (value = "hcId") Long hcId,
            @RequestBody DetalleHCModel detalle){
        return this.hcService.obtenerPorId(hcId).map(hc -> {
            detalle.setHistoria_clinica(hc);
            return this.detallesHcService.guardarDetalles(detalle);
        }).orElseThrow(() -> new RuntimeException("Resource Not Found"));
    }
    
    @PutMapping("/hcs/{hcId}/detalles/{detalleId}")
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
    
    @GetMapping("/colaboradores/{colabId}/detalles")
    public ArrayList<DetalleHCModel> obtenerDetallesByColaborador(
            @PathVariable (value = "colabId") Long colabId){
        return detallesHcService.obtenerDetallesByColaborador(colabId);
    }
    @GetMapping("detalles/{id}")
    public Optional<DetalleHCModel> obtenerDetallesHCById(
        @PathVariable("id") Long id) {
        return this.detallesHcService.obtenerPorId(id);
    }
    
    @DeleteMapping("detalles/{id}")
    public Set<String> eliminarPorId(@PathVariable("id") Long id){
        try{
            this.detallesHcService.eliminarDetalle(id);
            return Collections.singleton("Se eliminó el detalle  " + id);
        }catch(Exception err){
            return Collections.singleton("No se pudo eliminar el detalle " + id);
        }
    }
    
}

