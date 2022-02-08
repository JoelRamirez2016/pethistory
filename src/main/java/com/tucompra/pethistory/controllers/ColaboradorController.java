/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.ColaboradorModel;
import com.tucompra.pethistory.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Holberton
 */

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    ColaboradorService colaboradorService;

    @GetMapping()
    public ArrayList<ColaboradorModel> obtenerColaboradors(){
        return colaboradorService.obtenerColaboradors();
    }

    @PostMapping()
    public ColaboradorModel guardarColaborador(@RequestBody ColaboradorModel colaborador){
        return this.colaboradorService.guardarColaborador(colaborador);
    }
    
    @PutMapping( path = "/{id}")
    public ColaboradorModel actualizarColaborador(
        @PathVariable ("id") Long id, 
        @RequestBody ColaboradorModel colaborador){
       
        if(this.colaboradorService.obtenerPorId(id) == null) {
            throw new RuntimeException("colaboradorId " + id + " not found");
        }
        return this.colaboradorService.guardarColaborador(colaborador);
    }
    @GetMapping( path = "/{id}")
    public Optional<ColaboradorModel> obtenerColaboradorPorId(@PathVariable("id") Long id) {
        return this.colaboradorService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        try{
            this.colaboradorService.eliminarColaborador(id);
            return "Se eliminó el colaborador con id " + id;
        }catch(Exception err){
            return "No pudo eliminar el colaborador con id" + id;
        }
    }

}

