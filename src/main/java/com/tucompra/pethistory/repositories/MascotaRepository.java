/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.repositories;

import com.tucompra.pethistory.models.MascotaModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Holberton
 */
public interface MascotaRepository extends CrudRepository<MascotaModel, Long> {
    List<MascotaModel> findByUsuarioId(Long usuarioId);
}
