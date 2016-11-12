/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Lokator;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import szyfrowanie.CryptWithSHA256;
import javax.persistence.NoResultException;
/**
 *
 * @author Waldek
 */
@Stateless
public class LokatorFacade extends AbstractFacade<Lokator> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LokatorFacade() {
        super(Lokator.class);
    }
      public Short id() {
        Query q = em.createQuery("SELECT MAX(x.id) FROM Lokator x");
        Short result = (Short) q.getSingleResult();
        if (result == null) {
            result = 1;
        } else {
          result++;
        }
        return result;
    }
        public boolean sprawdzLogin(String log) {
        boolean wynik = false;
        try {
            EntityManager em = getEntityManager();
            Query query = em.createQuery("SELECT c.login FROM Lokator c WHERE c.login LIKE :login");
            query.setParameter("login", log);

            if (query.getSingleResult() != null) {
                wynik = true;
            }
        } catch (NoResultException e) {

            wynik = false;
        }
        return wynik;

    }
        public Lokator login(String log, String pass) {
        pass = CryptWithSHA256.sha256(pass);
        Lokator wynik= new Lokator();
        try {
             TypedQuery<Lokator> q2
                = em.createQuery("SELECT c FROM Lokator c WHERE c.login = :login AND c.haslo=:haslo  ", Lokator.class).setParameter("login", log).setParameter("haslo", pass);
            if (q2.getSingleResult() != null) {
                wynik = q2.getSingleResult();
            }
        } catch (NoResultException e) {

            wynik = null;
        }
        return wynik;
    }

}
