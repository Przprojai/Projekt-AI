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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Waldek
 */
@Entity
@Table(name = "wlasciciel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wlasciciel.findAll", query = "SELECT w FROM Wlasciciel w")
    , @NamedQuery(name = "Wlasciciel.findById", query = "SELECT w FROM Wlasciciel w WHERE w.id = :id")
    , @NamedQuery(name = "Wlasciciel.findByLogin", query = "SELECT w FROM Wlasciciel w WHERE w.login = :login")
    , @NamedQuery(name = "Wlasciciel.findByHaslo", query = "SELECT w FROM Wlasciciel w WHERE w.haslo = :haslo")
    , @NamedQuery(name = "Wlasciciel.findByKontakt", query = "SELECT w FROM Wlasciciel w WHERE w.kontakt = :kontakt")
    , @NamedQuery(name = "Wlasciciel.findByImie", query = "SELECT w FROM Wlasciciel w WHERE w.imie = :imie")
    , @NamedQuery(name = "Wlasciciel.findByNazwisko", query = "SELECT w FROM Wlasciciel w WHERE w.nazwisko = :nazwisko")})
public class Wlasciciel implements Serializable {

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
    @Size(min = 1, max = 256)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "kontakt")
    private String kontakt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "imie")
    private String imie;
    @Size(max = 25)
    @Column(name = "nazwisko")
    private String nazwisko;
    @JoinColumn(name = "budynek_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Budynek budynekId;

    public Wlasciciel() {
    }

    public Wlasciciel(Short id) {
        this.id = id;
    }

    public Wlasciciel(Short id, String login, String haslo, String kontakt, String imie) {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.kontakt = kontakt;
        this.imie = imie;
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
        if (!(object instanceof Wlasciciel)) {
            return false;
        }
        Wlasciciel other = (Wlasciciel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Wlasciciel[ id=" + id + " ]";
    }
    
}
