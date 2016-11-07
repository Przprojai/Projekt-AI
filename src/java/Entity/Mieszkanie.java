/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Waldek
 */
@Entity
@Table(name = "mieszkanie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mieszkanie.findAll", query = "SELECT m FROM Mieszkanie m")
    , @NamedQuery(name = "Mieszkanie.findById", query = "SELECT m FROM Mieszkanie m WHERE m.id = :id")
    , @NamedQuery(name = "Mieszkanie.findByIloscPokoi", query = "SELECT m FROM Mieszkanie m WHERE m.iloscPokoi = :iloscPokoi")
    , @NamedQuery(name = "Mieszkanie.findByBudynekId", query = "SELECT m FROM Mieszkanie m WHERE m.budynekId = :budynekId")})
public class Mieszkanie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilosc_pokoi")
    private short iloscPokoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "budynek_id")
    private short budynekId;

    public Mieszkanie() {
    }

    public Mieszkanie(Short id) {
        this.id = id;
    }

    public Mieszkanie(Short id, short iloscPokoi, short budynekId) {
        this.id = id;
        this.iloscPokoi = iloscPokoi;
        this.budynekId = budynekId;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getIloscPokoi() {
        return iloscPokoi;
    }

    public void setIloscPokoi(short iloscPokoi) {
        this.iloscPokoi = iloscPokoi;
    }

    public short getBudynekId() {
        return budynekId;
    }

    public void setBudynekId(short budynekId) {
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
        if (!(object instanceof Mieszkanie)) {
            return false;
        }
        Mieszkanie other = (Mieszkanie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Mieszkanie[ id=" + id + " ]";
    }
    
}
