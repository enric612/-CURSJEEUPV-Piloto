/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ecliment
 */
public class DAOFactory {
    
    public static PartitDAO getPartitDAO(){        
        
        Session session = HibernateUtil.getSession();        
        return new PartitDAOImpl(session);
    }
    
    public static EquipDAO getEquipDAO(){
        return new EquipDAOImpl(HibernateUtil.getSessionFactory().openSession());
    }
}
