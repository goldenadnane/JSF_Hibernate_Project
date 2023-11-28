/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Employe;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author adnan
 */
public class EmployeService extends AbstractFacade<Employe> {

    @Override
    protected Class<Employe>getEntityClass() {
        return Employe.class;
    }
    
    
    public List<Employe> getByChef(Employe chefDe) {
        List<Employe> employes = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        employes = session.createQuery("FROM Employe e WHERE e.chefDe = :chefDe")
                .setParameter("chefDe", chefDe)
                .list();

        session.getTransaction().commit();
        return employes;
    }
    
}
