/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.repositories;

import com.tucompra.pethistory.models.DetalleHCModel;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Holberton
 */

@Repository
public interface DetalleHCRepository extends CrudRepository<DetalleHCModel, Long> {
    List<DetalleHCModel> findByHistoriaClinicaId(Long hcId);
    List<DetalleHCModel> findByColaboradorId(Long colaboradorId);

}
