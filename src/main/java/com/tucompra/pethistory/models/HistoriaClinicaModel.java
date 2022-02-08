/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tucompra.pethistory.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Holberton
 */
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String fecha_creacion;   
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "mascota_id")
    private MascotaModel mascota;
    
    @OneToMany(mappedBy="historia_clinica")
    private List<DetalleHCModel> detalles;   

    public List<DetalleHCModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleHCModel> detalles) {
        this.detalles = detalles;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public MascotaModel getMascota() {
        return mascota;
    }

    public void setMascota(MascotaModel mascota) {
        this.mascota = mascota;
    }

    
}
