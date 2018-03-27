/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ovh.ecliment.cjee.piloto.domini.Partit;

/**
 *
 * @author ecliment
 */
public class PartitDAOImpl extends GenericHibernateDAO implements PartitDAO {

    public PartitDAOImpl(Session s) {
        super(s);
    }

    @Override
    public Partit findById(Integer id) {
        return (Partit) getSession().get(Partit.class, id);
    }

    @Override
    public List<Partit> findByJornada(String jornada) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<Partit> criteria = builder.createQuery(Partit.class);
        Root<Partit> root = criteria.from(Partit.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("jornada"), Integer.parseInt(jornada)));
        return getSession().createQuery(criteria).getResultList();
    }

    @Override
    public List<Partit> findByEquip(String equip) {
       Query q = getSession().createQuery("From Partit p "
                + "where p.equipByIdEquipLocal.nom = ?"
                + "or p.equipByIdEquipVisitant.nom = ?");

        q.setParameter(0, equip);
        q.setParameter(1, equip);
        return q.getResultList();
    }

    @Override
    public List<Partit> findAll() {
        Query q = getSession().createQuery("From Partit");
        return q.getResultList();
    }

    @Override
    public List<Partit> findBySimilarEquip(String nom) {
        Query q = getSession().createQuery("From Partit p "
                + "where lower(p.equipByIdEquipLocal.nom) like ?"
                + "or lower(p.equipByIdEquipVisitant.nom) like ?");

        q.setParameter(0, nom.toLowerCase() + "%");
        q.setParameter(1, nom.toLowerCase() + "%");
        return q.getResultList();
    }

    @Override
    public void save(Partit entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void remove(Partit entity) {
        getSession().delete(entity);
    }

}
