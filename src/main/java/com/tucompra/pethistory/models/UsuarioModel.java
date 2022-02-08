package com.tucompra.pethistory.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String tipo_documento;
    private Integer documento_identificacion;
    private String estado;
    private String sexo;
    
    @OneToMany(mappedBy="usuario")
    private List<MascotaModel> mascotas;   

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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<MascotaModel> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaModel> mascotas) {
        this.mascotas = mascotas;
    }
    
}
