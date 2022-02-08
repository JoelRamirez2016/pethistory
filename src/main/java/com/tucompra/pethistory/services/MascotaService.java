/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.services;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.MascotaModel;
import com.tucompra.pethistory.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Holberton
 */
@Service
public class MascotaService {
    @Autowired
    MascotaRepository mascotaRepository;
    
    public ArrayList<MascotaModel> obtenerMascotas(){
        return (ArrayList<MascotaModel>) mascotaRepository.findAll();
    }
    
    public ArrayList<MascotaModel> obtenerMascotasByUsuario(Long usuarioId){
        return (ArrayList<MascotaModel>) mascotaRepository.findByUsuarioId(usuarioId);
    }

    @Transactional
    public MascotaModel guardarMascota(MascotaModel mascota){
        return mascotaRepository.save(mascota);
    }

    public Optional<MascotaModel> obtenerPorId(Long id){
        return mascotaRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}
