package com.anita.web;

import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author A-n-I-t-A
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_u")
    private Integer id_u;
    
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;

    @Size(max = 80)
    @Column(name = "apellido_paterno")
    private String apellido_paterno;
    
    @Size(max = 80)
    @Column(name = "apellido_materno")
    private String apellido_materno;
    
    @Size(max = 80)
    @Column(name = "carrera")
    private String carrera;
    
    @Size(max = 80)
    @Column(name = "correo")
    private String correo;

    public Integer getId_u() {
        return id_u;
    }

    public void setId_u(Integer id_u) {
        this.id_u = id_u;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario(Integer id_u, String nombre, String apellido_paterno, String apellido_materno, String carrera, String correo) {
        this.id_u = id_u;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.carrera = carrera;
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id_u != null ? this.id_u.hashCode() : 0);
        hash = 59 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 59 * hash + (this.apellido_paterno != null ? this.apellido_paterno.hashCode() : 0);
        hash = 59 * hash + (this.apellido_materno != null ? this.apellido_materno.hashCode() : 0);
        hash = 59 * hash + (this.carrera != null ? this.carrera.hashCode() : 0);
        hash = 59 * hash + (this.correo != null ? this.correo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id_u != other.id_u && (this.id_u == null || !this.id_u.equals(other.id_u))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.apellido_paterno == null) ? (other.apellido_paterno != null) : !this.apellido_paterno.equals(other.apellido_paterno)) {
            return false;
        }
        if ((this.apellido_materno == null) ? (other.apellido_materno != null) : !this.apellido_materno.equals(other.apellido_materno)) {
            return false;
        }
        if ((this.carrera == null) ? (other.carrera != null) : !this.carrera.equals(other.carrera)) {
            return false;
        }
        return true;
    }
    
}

    
