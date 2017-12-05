/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author skaynx
 */
@Entity
@Table(name = "cantante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cantante.findAll", query = "SELECT c FROM Cantante c")
    , @NamedQuery(name = "Cantante.findById", query = "SELECT c FROM Cantante c WHERE c.id = :id")
    , @NamedQuery(name = "Cantante.findByNombre", query = "SELECT c FROM Cantante c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cantante.findByFechaNac", query = "SELECT c FROM Cantante c WHERE c.fechaNac = :fechaNac")
    , @NamedQuery(name = "Cantante.findByNacionalidad", query = "SELECT c FROM Cantante c WHERE c.nacionalidad = :nacionalidad")})
public class Cantante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @JoinColumn(name = "genero", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Genero genero;

    public Cantante() {
    }

    public Cantante(Integer id) {
        this.id = id;
    }

    public Cantante(Integer id, String nombre, Date fechaNac, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
    }
    
    public Cantante(String nombre, Date fechaNac, String nacionalidad, Genero genero) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cantante)) {
            return false;
        }
        Cantante other = (Cantante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cantante[ id=" + id + " ]";
    }
    
}
