package com.anita.web;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author T-202
 */
@Entity
@Table(name = "libros")
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")})
public class Libros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_l")
    private Integer idL;
    @Size(max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 80)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 80)
    @Column(name = "autor")
    private String autor;
    @Size(max = 80)
    @Column(name = "editorial")
    private String editorial;
    

    public Libros() {
    }

    public Libros(Integer idL) {
        this.idL = idL;
    }

    public Integer getIdL() {
        return idL;
    }

    public void setIdL(Integer idL) {
        this.idL = idL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idL != null ? idL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idL == null && other.idL != null) || (this.idL != null && !this.idL.equals(other.idL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.anita.web.Libros[ idL=" + idL + " ]";
    }
    
}
