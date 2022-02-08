/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.MascotaModel;
import com.tucompra.pethistory.services.MascotaService;
import com.tucompra.pethistory.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Holberton
 */

@RestController
@RequestMapping
public class MascotaController {
    @Autowired
    MascotaService mascotaService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios/{usuarioId}/mascotas")
    public ArrayList<MascotaModel> obtenerMascotasByUsuario(@PathVariable (value = "usuarioId") Long usuarioId){
        return mascotaService.obtenerMascotasByUsuario(usuarioId);
    }

    @PostMapping("/usuarios/{usuarioId}/mascotas")
    public MascotaModel guardarMascota(@PathVariable (value = "usuarioId") Long usuarioId,
                                        @RequestBody MascotaModel mascota){
        return this.usuarioService.obtenerPorId(usuarioId).map(usuario -> {
            mascota.setUsuario(usuario);
            return this.mascotaService.guardarMascota(mascota);
        }).orElseThrow(() -> new RuntimeException("Resource Not Found"));
    }
    
    @PutMapping("/usuarios/{usuarioId}/mascotas/{mascotaId}")
    public MascotaModel actualizarMascota(@PathVariable (value = "usuarioId") Long usuarioId, 
        @PathVariable (value = "mascotaId") Long mascotaId, 
        @RequestBody MascotaModel mascota){

        if(this.usuarioService.obtenerPorId(usuarioId) == null) {
            throw new RuntimeException("usuarioId " + usuarioId + " not found");
        }
        if(this.mascotaService.obtenerPorId(mascotaId) == null) {
            throw new RuntimeException("mascotaId " + mascotaId + " not found");
        }
        return this.mascotaService.guardarMascota(mascota);
    }
    
    @GetMapping("mascotas/{id}")
    public Optional<MascotaModel> obtenerMascotaPorId(@PathVariable("id") Long id) {
        return this.mascotaService.obtenerPorId(id);
    }
    
    @DeleteMapping("mascotas/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        try{
            this.mascotaService.eliminarMascota(id);
            return "Se eliminó el mascota con id " + id;
        }catch(Exception err){
            return "No pudo eliminar el mascota con id " + id;
        }
    }
    
}

