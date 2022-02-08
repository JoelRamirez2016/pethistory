/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.services;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.HistoriaClinicaModel;
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
    
    public HistoriaClinicaModel obtenerHistoriaClinicaByMascota(Long mascotaId){
        return historiaClinicaRepository.findByMascotaId(mascotaId);
    }

    @Transactional
    public HistoriaClinicaModel guardarHistoriaClinica(HistoriaClinicaModel hc){
        return historiaClinicaRepository.save(hc);
    }

    public Optional<HistoriaClinicaModel> obtenerPorId(Long id){
        return historiaClinicaRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void eliminarHistoriaClinica(Long id) {
        historiaClinicaRepository.deleteById(id);
    }
}
