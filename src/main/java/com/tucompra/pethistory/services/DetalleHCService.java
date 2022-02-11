/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.services;

import com.tucompra.pethistory.models.DetalleHCModel;
import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.repositories.DetalleHCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Holberton
 */
@Service
public class DetalleHCService {
    @Autowired
    DetalleHCRepository detallehcRepository;
    
    public ArrayList<DetalleHCModel> obtenerDetalles(){
        return (ArrayList<DetalleHCModel>) detallehcRepository.findAll();
    }
    
    public ArrayList<DetalleHCModel> obtenerDetallesByHistoriaClinica(Long hcId){
        return (ArrayList<DetalleHCModel>) detallehcRepository.findByHistoriaClinica_Id(hcId);
    }
    
    public ArrayList<DetalleHCModel> obtenerDetallesByColaborador(Long colabId){
        return (ArrayList<DetalleHCModel>) detallehcRepository.findByColaboradorId(colabId);
    }

    @Transactional
    public DetalleHCModel guardarDetalles(DetalleHCModel detallehc){
        return detallehcRepository.save(detallehc);
    }

    public Optional<DetalleHCModel> obtenerPorId(Long id){
        return detallehcRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void eliminarDetalle(Long id) {
        detallehcRepository.deleteById(id);
    }
}
