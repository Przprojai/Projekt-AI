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
@Table(name = "awaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Awaria.findAll", query = "SELECT a FROM Awaria a")
    , @NamedQuery(name = "Awaria.findById", query = "SELECT a FROM Awaria a WHERE a.id = :id")
    , @NamedQuery(name = "Awaria.findByDataZgloszenia", query = "SELECT a FROM Awaria a WHERE a.dataZgloszenia = :dataZgloszenia")
    , @NamedQuery(name = "Awaria.findByOpis", query = "SELECT a FROM Awaria a WHERE a.opis = :opis")  
    , @NamedQuery(name = "Awaria.findByRozwiazane", query = "SELECT a FROM Awaria a WHERE a.rozwiazane = :rozwiazane")})
public class Awaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_zgloszenia")
    @Temporal(TemporalType.DATE)
    private Date dataZgloszenia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rozwiazane")
    private boolean rozwiazane;
    @JoinColumn(name = "budynek_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Budynek budynekId;
    @JoinColumn(name = "lokator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Lokator lokatorId;

    public Awaria() {
    }

    public Awaria(Short id) {
        this.id = id;
    }

    public Awaria(Short id, Date dataZgloszenia, String opis, boolean rozwiazane) {
        this.id = id;
        this.dataZgloszenia = dataZgloszenia;
        this.opis = opis;
        this.rozwiazane = rozwiazane;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Date getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(Date dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean getRozwiazane() {
        return rozwiazane;
    }

    public void setRozwiazane(boolean rozwiazane) {
        this.rozwiazane = rozwiazane;
    }

    public Budynek getBudynekId() {
        return budynekId;
    }

    public void setBudynekId(Budynek budynekId) {
        this.budynekId = budynekId;
    }

    public Lokator getLokatorId() {
        return lokatorId;
    }

    public void setLokatorId(Lokator lokatorId) {
        this.lokatorId = lokatorId;
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
        if (!(object instanceof Awaria)) {
            return false;
        }
        Awaria other = (Awaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Awaria[ id=" + id + " ]";
    }
    
}
