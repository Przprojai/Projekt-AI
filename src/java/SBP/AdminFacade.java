/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBP;

import Entity.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import szyfrowanie.CryptWithSHA256;

/**
 *
 * @author Waldek
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {

    @PersistenceContext(unitName = "AWZNPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }
     public boolean login(String log,String pass) {
             pass=CryptWithSHA256.sha256(pass);
        boolean wynik = false;
         try{
        EntityManager em=getEntityManager();
      Query query  = em.createQuery("SELECT c.login,c.haslo FROM Admin c WHERE c.login LIKE :login AND c.haslo LIKE :haslo");
      query.setParameter("login", log);
      query.setParameter("haslo", pass);
     // query.setParameter("pesel", pesel);
//if(query.getResultList().equals(em));
    
       if(query.getSingleResult()!=null)
          wynik = true;
     }
     catch(javax.persistence.NoResultException e)
     {
         
      wynik = false;  
     }
         return wynik;
         }
}
