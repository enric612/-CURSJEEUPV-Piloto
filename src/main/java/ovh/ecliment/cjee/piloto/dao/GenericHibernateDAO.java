/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import org.hibernate.Session;

/**
 *
 * @author ecliment
 */
public abstract class GenericHibernateDAO {
    
    private Session session;
    
    public GenericHibernateDAO(Session s){
        this.session = s;
    }
    
    public void setSession(Session s){
        this.session = s;        
    }
    
    public Session getSession()
    {
        if(session == null)
            throw new IllegalStateException(
                    "No s'ha definit una sessión abans d'utilitzar este DAO"
            );
        return this.session;
    }
           
    
}
