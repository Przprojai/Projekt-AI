/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Oplaty;
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
public class OplatyFacade extends AbstractFacade<Oplaty> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OplatyFacade() {
        super(Oplaty.class);
    }
    public List<Oplaty> findbymieszkanieid(Short mieszkanieid){
      //  Budynek budynekId=lokator.getMieszkanieId().getBudynekId();
        TypedQuery<Oplaty> query=
                em.createQuery("SELECT a FROM Oplaty a WHERE a.id=:mieszkanieid",Oplaty.class).setParameter("mieszkanieid", mieszkanieid);
        List<Oplaty> wynik = query.getResultList();
        return wynik;
    }
    
}
