/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.services;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.HistoriaClinicaModel;
import com.tucompra.pethistory.repositories.HistoriaClinicaRepository;
import com.tucompra.pethistory.repositories.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Holberton
 */
@Service
public class HistoriaClinicaService {
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;
    
    public ArrayList<HistoriaClinicaModel> obtenerHistoriasClinicas(){
        return (ArrayList<HistoriaClinicaModel>) historiaClinicaRepository.findAll();
    }
    
    public ArrayList<HistoriaClinicaModel> obtenerHistoriaClinicaByMascota(Long usuarioId){
        return (ArrayList<HistoriaClinicaModel>) historiaClinicaRepository.findByMascotaId(usuarioId);
    }

    @Transactional
    public HistoriaClinicaModel guardarHistoriaClinica(HistoriaClinicaModel mascota){
        return historiaClinicaRepository.save(mascota);
    }

    public Optional<HistoriaClinicaModel> obtenerPorId(Long id){
        return historiaClinicaRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void eliminaristoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}
