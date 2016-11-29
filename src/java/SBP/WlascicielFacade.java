/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Wlasciciel;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Waldek
 */
@Stateless
public class WlascicielFacade extends AbstractFacade<Wlasciciel> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WlascicielFacade() {
        super(Wlasciciel.class);
    }
    public List<Wlasciciel> findbybudynekid(Short budynekid){
      //  Budynek budynekId=lokator.getMieszkanieId().getBudynekId();
        TypedQuery<Wlasciciel> query=
                em.createQuery("SELECT a FROM Wlasciciel a WHERE a.id=:budynekid",Wlasciciel.class).setParameter("budynekid", budynekid);
        List<Wlasciciel> wynik = query.getResultList();
        return wynik;
    }
}
