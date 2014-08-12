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
import javax.validation.constraints.Size;

/**
 *
 * @author T-202
 */
@Entity
@Table(name = "prestamos")
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p")})
public class Prestamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_p")
    private Integer idP;
    @Column(name = "dia_prestamo")
    @Temporal(TemporalType.DATE)
    private Date diaPrestamo;
    @Column(name = "dia_entrega")
    @Temporal(TemporalType.DATE)
    private Date diaEntrega;
    @Size(max = 50)
    @Column(name = "nombre_libro")
    private String nombreLibro;
    @JoinColumn(name = "id_u", referencedColumnName = "id_u")
    @ManyToOne
    private Usuario idU;
    @JoinColumn(name = "id_l", referencedColumnName = "id_l")
    @ManyToOne
    private Libros idL;

    public Prestamos() {
    }

    public Prestamos(Integer idP) {
        this.idP = idP;
    }

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
        this.idP = idP;
    }

    public Date getDiaPrestamo() {
        return diaPrestamo;
    }

    public void setDiaPrestamo(Date diaPrestamo) {
        this.diaPrestamo = diaPrestamo;
    }

    public Date getDiaEntrega() {
        return diaEntrega;
    }

    public void setDiaEntrega(Date diaEntrega) {
        this.diaEntrega = diaEntrega;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Usuario getIdU() {
        return idU;
    }

    public void setIdU(Usuario idU) {
        this.idU = idU;
    }

    public Libros getIdL() {
        return idL;
    }

    public void setIdL(Libros idL) {
        this.idL = idL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idP != null ? idP.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.idP == null && other.idP != null) || (this.idP != null && !this.idP.equals(other.idP))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anita.web.Prestamos[ idP=" + idP + " ]";
    }
    
}
