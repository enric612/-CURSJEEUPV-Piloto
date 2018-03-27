/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ovh.ecliment.cjee.piloto.domini.Equip;

/**
 *
 * @author ecliment
 */
public class EquipDAOImpl extends GenericHibernateDAO implements EquipDAO {

    public EquipDAOImpl(Session s) {
        super(s);
    }

    @Override
    public List<Equip> findAll() {
        Query q = getSession().createQuery("From Equip");
        return q.list();
    }

    @Override
    public Equip findById(Integer id) {
        Equip entity;
        entity = (Equip) getSession().get(Equip.class, id);
        return entity;
    }

}
