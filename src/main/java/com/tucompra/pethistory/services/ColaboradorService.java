/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.services;

import java.util.ArrayList;
import java.util.Optional;
import com.tucompra.pethistory.models.ColaboradorModel;
import com.tucompra.pethistory.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Holberton
 */
@Service
public class ColaboradorService {
    @Autowired
    ColaboradorRepository colaboradorRepository;
    
    public ArrayList<ColaboradorModel> obtenerColaboradors(){
        return (ArrayList<ColaboradorModel>) colaboradorRepository.findAll();
    }
    
    @Transactional
    public ColaboradorModel guardarColaborador(ColaboradorModel colaborador){
        return colaboradorRepository.save(colaborador);
    }

    public Optional<ColaboradorModel> obtenerPorId(Long id){
        return colaboradorRepository.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void eliminarColaborador(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
