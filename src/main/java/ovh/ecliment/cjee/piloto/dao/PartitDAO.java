/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import java.util.List;
import ovh.ecliment.cjee.piloto.domini.Partit;

/**
 *
 * @author ecliment
 */
public interface PartitDAO {

    Partit findById(Integer id);

    List<Partit> findByJornada(String jornada);

    List<Partit> findByEquip(String equip);

    List<Partit> findAll();

    List<Partit> findBySimilarEquip(String nom);

    void save(Partit entity);

    void remove(Partit entity);

}
