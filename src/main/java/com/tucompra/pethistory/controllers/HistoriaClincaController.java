/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.HistoriaClinicaModel;
import com.tucompra.pethistory.services.HistoriaClinicaService;
import com.tucompra.pethistory.services.MascotaService;
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
public class HistoriaClincaController {
    @Autowired
    HistoriaClinicaService hcService;
    @Autowired
    MascotaService mascotaService;

    @GetMapping("/hcs")
    public ArrayList<HistoriaClinicaModel> obtenerHistoriasClinicas(){
        return hcService.obtenerHistoriasClinicas();
    }
    
    @GetMapping("/mascotas/{mascotaId}/hc")
    public HistoriaClinicaModel obtenerHistoriaClinicaByMascota(
            @PathVariable (value = "mascotaId") Long mascotaId){
        return hcService.obtenerHistoriaClinicaByMascota(mascotaId);
    }

    @PostMapping("/mascotas/{mascotaId}/hc")
    public HistoriaClinicaModel guardarHistoriaClinica(
            @PathVariable (value = "mascotaId") Long mascotaId,
            @RequestBody HistoriaClinicaModel hc){
        return this.mascotaService.obtenerPorId(mascotaId).map(mascota -> {
            hc.setMascota(mascota);
            return this.hcService.guardarHistoriaClinica(hc);
        }).orElseThrow(() -> new RuntimeException("Resource Not Found"));
    }
    
    @PutMapping("/mascotas/{mascotaId}/hc/{hcId}")
    public HistoriaClinicaModel actualizarHistoriaClinica(@PathVariable (value = "mascotaId") Long mascotaId, 
        @PathVariable (value = "hcId") Long hcId, 
        @RequestBody HistoriaClinicaModel mascota){

        if(this.mascotaService.obtenerPorId(mascotaId) == null) {
            throw new RuntimeException("mascota " + mascotaId + " not found");
        }
        if(this.hcService.obtenerPorId(mascotaId) == null) {
            throw new RuntimeException("historia clinica " + mascotaId + " not found");
        }
        return this.hcService.guardarHistoriaClinica(mascota);
    }
    
    @GetMapping("hcs/{id}")
    public Optional<HistoriaClinicaModel> obtenerHistoriaClinicaPorId(@PathVariable("id") Long id) {
        return this.hcService.obtenerPorId(id);
    }
    
    @DeleteMapping("hcs/{id}")
    public Set<String> eliminarPorId(@PathVariable("id") Long id){
        try{
            this.hcService.eliminarHistoriaClinica(id);
            return Collections.singleton("Se eliminó el historia clinica con id " + id);
        }catch(Exception err){
            return Collections.singleton("No se pudo eliminar el historia clinica con id " + id);
        }
    }
    
}

