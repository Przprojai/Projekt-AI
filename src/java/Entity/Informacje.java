/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Waldek
 */
@Entity
@Table(name = "informacje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informacje.findAll", query = "SELECT i FROM Informacje i")
    , @NamedQuery(name = "Informacje.findById", query = "SELECT i FROM Informacje i WHERE i.id = :id")
    , @NamedQuery(name = "Informacje.findByData", query = "SELECT i FROM Informacje i WHERE i.data = :data")
    , @NamedQuery(name = "Informacje.findByOpis", query = "SELECT i FROM Informacje i WHERE i.opis = :opis")})
public class Informacje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "opis")
    private String opis;
    @JoinColumn(name = "budynek_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Budynek budynekId;

    public Informacje() {
    }

    public Informacje(Short id) {
        this.id = id;
    }

    public Informacje(Short id, Date data, String opis) {
        this.id = id;
        this.data = data;
        this.opis = opis;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Budynek getBudynekId() {
        return budynekId;
    }

    public void setBudynekId(Budynek budynekId) {
        this.budynekId = budynekId;
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
        if (!(object instanceof Informacje)) {
            return false;
        }
        Informacje other = (Informacje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Informacje[ id=" + id + " ]";
    }
    
}
