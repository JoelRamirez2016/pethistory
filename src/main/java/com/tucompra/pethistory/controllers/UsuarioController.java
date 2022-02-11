/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.UsuarioModel;
import com.tucompra.pethistory.services.UsuarioService;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }
    
    @PutMapping( path = "/{id}")
    public UsuarioModel actualizarUsuario(@PathVariable("id") Long id,
            @RequestBody UsuarioModel usuario){
        if(this.usuarioService.obtenerPorId(id) == null) {
            throw new RuntimeException("usuario " + id + " not found");
        }
        return this.usuarioService.guardarUsuario(usuario);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public Set<String> eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return Collections.singleton("Se eliminó el usuario con id " + id);
        }else{
            return Collections.singleton("No pudo eliminar el usuario con id" + id);
        }
    }

}

