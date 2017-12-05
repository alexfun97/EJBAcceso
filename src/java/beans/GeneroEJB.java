/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Stateless
public class GeneroEJB {

    @PersistenceUnit
    EntityManagerFactory emf;
    public List findAll(){
        return emf.createEntityManager().createNamedQuery("Genero.findAll").getResultList();
    }
    
}
