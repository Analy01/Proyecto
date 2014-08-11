package com.anita.web;

import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author A-n-I-t-A
 */
@Entity
@Table(name = "Libros")
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "id_l")
    private Integer id_l;
    
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
    

    Libro(String nombre, String titulo, String autor, String editorial) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId_l() {
        return id_l;
    }

    public void setId_l(Integer id_l) {
        this.id_l = id_l;
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


    public Libro(Integer id_l, String nombre, String titulo, String autor, String editorial, Integer anio) {
        this.id_l = id_l;
        this.nombre = nombre;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.id_l != null ? this.id_l.hashCode() : 0);
        hash = 41 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 41 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 41 * hash + (this.autor != null ? this.autor.hashCode() : 0);
        hash = 41 * hash + (this.editorial != null ? this.editorial.hashCode() : 0);
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
        final Libro other = (Libro) obj;
        if (this.id_l != other.id_l && (this.id_l == null || !this.id_l.equals(other.id_l))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.autor == null) ? (other.autor != null) : !this.autor.equals(other.autor)) {
            return false;
        }
        if ((this.editorial == null) ? (other.editorial != null) : !this.editorial.equals(other.editorial)) {
            return false;
        }
        return true;
    }
     
}

    

    