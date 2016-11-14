/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Awaria;
import Entity.Budynek;
import Entity.Lokator;
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
public class AwariaFacade extends AbstractFacade<Awaria> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AwariaFacade() {
        super(Awaria.class);
    }
    public List<Awaria> findbylokatorid(Lokator lokator){
        Budynek budynekId=lokator.getMieszkanieId().getBudynekId();
        TypedQuery<Awaria> query=
                em.createQuery("SELECT a FROM Awaria a WHERE a.budynekId=:budynekId",Awaria.class).setParameter("budynekId", budynekId);
        List<Awaria> wynik = query.getResultList();
        return wynik;
    }
    
}
