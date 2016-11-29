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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "lokator")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokator.findAll", query = "SELECT l FROM Lokator l")
    , @NamedQuery(name = "Lokator.findById", query = "SELECT l FROM Lokator l WHERE l.id = :id")
    , @NamedQuery(name = "Lokator.findByLogin", query = "SELECT l FROM Lokator l WHERE l.login = :login")
    , @NamedQuery(name = "Lokator.findByHaslo", query = "SELECT l FROM Lokator l WHERE l.haslo = :haslo")
    , @NamedQuery(name = "Lokator.findByKontakt", query = "SELECT l FROM Lokator l WHERE l.kontakt = :kontakt")
    , @NamedQuery(name = "Lokator.findByAktywne", query = "SELECT l FROM Lokator l WHERE l.aktywne = :aktywne")
    , @NamedQuery(name = "Lokator.findByImie", query = "SELECT l FROM Lokator l WHERE l.imie = :imie")
    , @NamedQuery(name = "Lokator.sprawdzAktywne", query = "SELECT l FROM Lokator l WHERE l.login = :login")
    , @NamedQuery(name = "Lokator.findByNazwisko", query = "SELECT l FROM Lokator l WHERE l.nazwisko = :nazwisko")})
public class Lokator implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lokatorId")
    private Collection<Awaria> awariaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "kontakt")
    private String kontakt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aktywne")
    private boolean aktywne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nazwisko")
    private String nazwisko;
    @JoinColumn(name = "mieszkanie_id", referencedColumnName = "id")
    @ManyToOne
    private Mieszkanie mieszkanieId;

    public Lokator() {
    }

    public Lokator(Short id) {
        this.id = id;
    }

    public Lokator(Short id, String login, String haslo, String kontakt, boolean aktywne, String imie, String nazwisko) {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.kontakt = kontakt;
        this.aktywne = aktywne;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public boolean getAktywne() {
        return aktywne;
    }

    public void setAktywne(boolean aktywne) {
        this.aktywne = aktywne;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Mieszkanie getMieszkanieId() {
        return mieszkanieId;
    }

    public void setMieszkanieId(Mieszkanie mieszkanieId) {
        this.mieszkanieId = mieszkanieId;
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
        if (!(object instanceof Lokator)) {
            return false;
        }
        Lokator other = (Lokator) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return imie +" " + nazwisko;
    }

    @XmlTransient
    public Collection<Awaria> getAwariaCollection() {
        return awariaCollection;
    }

    public void setAwariaCollection(Collection<Awaria> awariaCollection) {
        this.awariaCollection = awariaCollection;
    }
    
}
