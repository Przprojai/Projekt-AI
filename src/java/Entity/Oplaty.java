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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Waldek
 */
@Entity
@Table(name = "oplaty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oplaty.findAll", query = "SELECT o FROM Oplaty o")
    , @NamedQuery(name = "Oplaty.findById", query = "SELECT o FROM Oplaty o WHERE o.id = :id")
    , @NamedQuery(name = "Oplaty.findByCzynsz", query = "SELECT o FROM Oplaty o WHERE o.czynsz = :czynsz")
    , @NamedQuery(name = "Oplaty.findByWodaIScieki", query = "SELECT o FROM Oplaty o WHERE o.wodaIScieki = :wodaIScieki")
    , @NamedQuery(name = "Oplaty.findByOgrzewanie", query = "SELECT o FROM Oplaty o WHERE o.ogrzewanie = :ogrzewanie")
    , @NamedQuery(name = "Oplaty.findByMedia", query = "SELECT o FROM Oplaty o WHERE o.media = :media")})
public class Oplaty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "czynsz")
    private short czynsz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "woda_i_scieki")
    private short wodaIScieki;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ogrzewanie")
    private short ogrzewanie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "media")
    private short media;
    @JoinColumn(name = "mieszkanie_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mieszkanie mieszkanieId;

    public Oplaty() {
    }

    public Oplaty(Short id) {
        this.id = id;
    }

    public Oplaty(Short id, short czynsz, short wodaIScieki, short ogrzewanie, short media) {
        this.id = id;
        this.czynsz = czynsz;
        this.wodaIScieki = wodaIScieki;
        this.ogrzewanie = ogrzewanie;
        this.media = media;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public short getCzynsz() {
        return czynsz;
    }

    public void setCzynsz(short czynsz) {
        this.czynsz = czynsz;
    }

    public short getWodaIScieki() {
        return wodaIScieki;
    }

    public void setWodaIScieki(short wodaIScieki) {
        this.wodaIScieki = wodaIScieki;
    }

    public short getOgrzewanie() {
        return ogrzewanie;
    }

    public void setOgrzewanie(short ogrzewanie) {
        this.ogrzewanie = ogrzewanie;
    }

    public short getMedia() {
        return media;
    }

    public void setMedia(short media) {
        this.media = media;
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
        if (!(object instanceof Oplaty)) {
            return false;
        }
        Oplaty other = (Oplaty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return mieszkanieId.getBudynekId().getAdres()+" "+id;
    }
    
}
