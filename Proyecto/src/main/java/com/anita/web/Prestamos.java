package com.anita.web;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author A-n-I-t-A
 */
@Entity
@Table(name = "Prestamos")
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_p")
    private Integer id_p;
    
    @Column(name = "dia_prestamo")
    @Temporal(TemporalType.DATE)
    private Date dia_prestamo;
    
    @Column(name = "dia_entrega")
    @Temporal(TemporalType.DATE)
    private Date dia_entrega;
    
    @Column(name = "nombre_libro")
    @Temporal(TemporalType.DATE)
    private Date nombre_libro;
    
    @JoinColumn(name = "id_u", referencedColumnName = "id_u")
    @ManyToOne
    private Usuario id_u;
    @JoinColumn(name = "id_l", referencedColumnName = "id_l")
    @ManyToOne
    private Libro id_l;

    public Integer getId_p() {
        return id_p;
    }

    public void setId_p(Integer id_p) {
        this.id_p = id_p;
    }

    public Date getDia_prestamo() {
        return dia_prestamo;
    }

    public void setDia_prestamo(Date dia_prestamo) {
        this.dia_prestamo = dia_prestamo;
    }

    public Date getDia_entrega() {
        return dia_entrega;
    }

    public void setDia_entrega(Date dia_entrega) {
        this.dia_entrega = dia_entrega;
    }

    public Date getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(Date nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public Usuario getId_u() {
        return id_u;
    }

    public void setId_u(Usuario id_u) {
        this.id_u = id_u;
    }

    public Libro getId_l() {
        return id_l;
    }

    public void setId_l(Libro id_l) {
        this.id_l = id_l;
    }

    public Prestamos(Integer id_p, Date dia_prestamo, Date dia_entrega, Date nombre_libro, Usuario id_u, Libro id_l) {
        this.id_p = id_p;
        this.dia_prestamo = dia_prestamo;
        this.dia_entrega = dia_entrega;
        this.nombre_libro = nombre_libro;
        this.id_u = id_u;
        this.id_l = id_l;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id_p != null ? this.id_p.hashCode() : 0);
        hash = 53 * hash + (this.dia_prestamo != null ? this.dia_prestamo.hashCode() : 0);
        hash = 53 * hash + (this.dia_entrega != null ? this.dia_entrega.hashCode() : 0);
        hash = 53 * hash + (this.nombre_libro != null ? this.nombre_libro.hashCode() : 0);
        hash = 53 * hash + (this.id_u != null ? this.id_u.hashCode() : 0);
        hash = 53 * hash + (this.id_l != null ? this.id_l.hashCode() : 0);
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
        final Prestamos other = (Prestamos) obj;
        if (this.id_p != other.id_p && (this.id_p == null || !this.id_p.equals(other.id_p))) {
            return false;
        }
        if (this.dia_prestamo != other.dia_prestamo && (this.dia_prestamo == null || !this.dia_prestamo.equals(other.dia_prestamo))) {
            return false;
        }
        if (this.dia_entrega != other.dia_entrega && (this.dia_entrega == null || !this.dia_entrega.equals(other.dia_entrega))) {
            return false;
        }
        if (this.nombre_libro != other.nombre_libro && (this.nombre_libro == null || !this.nombre_libro.equals(other.nombre_libro))) {
            return false;
        }
        if (this.id_u != other.id_u && (this.id_u == null || !this.id_u.equals(other.id_u))) {
            return false;
        }
        if (this.id_l != other.id_l && (this.id_l == null || !this.id_l.equals(other.id_l))) {
            return false;
        }
        return true;
    }
    
    
}

