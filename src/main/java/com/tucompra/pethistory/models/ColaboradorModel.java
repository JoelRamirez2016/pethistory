package com.tucompra.pethistory.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "colaborador")
public class ColaboradorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String tipo_documento;
    private Integer documento_identificacion;
    private String cargo;
    
    @OneToOne(mappedBy = "colaborador", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private DetalleHCModel detalle;   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public Integer getDocumento_identificacion() {
        return documento_identificacion;
    }

    public void setDocumento_identificacion(Integer documento_identificacion) {
        this.documento_identificacion = documento_identificacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public DetalleHCModel getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleHCModel detalle) {
        this.detalle = detalle;
    }
        
}
