/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Budynek;
import Entity.Informacje;
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
public class InformacjeFacade extends AbstractFacade<Informacje> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InformacjeFacade() {
        super(Informacje.class);
    }
     public List<Informacje> findbybudynekid(Budynek budynekId){
      //  Budynek budynekId=lokator.getMieszkanieId().getBudynekId();
        TypedQuery<Informacje> query=
                em.createQuery("SELECT a FROM Informacje a WHERE a.budynekId=:budynekId",Informacje.class).setParameter("budynekId", budynekId);
        List<Informacje> wynik = query.getResultList();
        return wynik;
    }
}
