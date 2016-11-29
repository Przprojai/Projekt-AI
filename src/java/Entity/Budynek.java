/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Waldek
 */
@Entity
@Table(name = "budynek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Budynek.findAll", query = "SELECT b FROM Budynek b")
    , @NamedQuery(name = "Budynek.findById", query = "SELECT b FROM Budynek b WHERE b.id = :id")
    , @NamedQuery(name = "Budynek.findByAdres", query = "SELECT b FROM Budynek b WHERE b.adres = :adres")
    , @NamedQuery(name = "Budynek.findByIloscMieszkan", query = "SELECT b FROM Budynek b WHERE b.iloscMieszkan = :iloscMieszkan")})
public class Budynek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "adres")
    private String adres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ilosc_mieszkan")
    private short iloscMieszkan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budynekId")
    private Collection<Wlasciciel> wlascicielCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budynekId")
    private Collection<Informacje> informacjeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budynekId")
    private Collection<Mieszkanie> mieszkanieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "budynekId")
    private Collection<Awaria> awariaCollection;

    public Budynek() {
    }

    public Budynek(Short id) {
        this.id = id;
    }

    public Budynek(Short id, String adres, short iloscMieszkan) {
        this.id = id;
        this.adres = adres;
        this.iloscMieszkan = iloscMieszkan;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public short getIloscMieszkan() {
        return iloscMieszkan;
    }

    public void setIloscMieszkan(short iloscMieszkan) {
        this.iloscMieszkan = iloscMieszkan;
    }

    @XmlTransient
    public Collection<Wlasciciel> getWlascicielCollection() {
        return wlascicielCollection;
    }

    public void setWlascicielCollection(Collection<Wlasciciel> wlascicielCollection) {
        this.wlascicielCollection = wlascicielCollection;
    }

    @XmlTransient
    public Collection<Informacje> getInformacjeCollection() {
        return informacjeCollection;
    }

    public void setInformacjeCollection(Collection<Informacje> informacjeCollection) {
        this.informacjeCollection = informacjeCollection;
    }

    @XmlTransient
    public Collection<Mieszkanie> getMieszkanieCollection() {
        return mieszkanieCollection;
    }

    public void setMieszkanieCollection(Collection<Mieszkanie> mieszkanieCollection) {
        this.mieszkanieCollection = mieszkanieCollection;
    }

    @XmlTransient
    public Collection<Awaria> getAwariaCollection() {
        return awariaCollection;
    }

    public void setAwariaCollection(Collection<Awaria> awariaCollection) {
        this.awariaCollection = awariaCollection;
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
        if (!(object instanceof Budynek)) {
            return false;
        }
        Budynek other = (Budynek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return adres;
    }
    
}
