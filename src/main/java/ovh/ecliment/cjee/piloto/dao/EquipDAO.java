/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import java.util.List;
import ovh.ecliment.cjee.piloto.domini.Equip;

/**
 *
 * @author ecliment
 */
public interface EquipDAO {

    List<Equip> findAll();

    Equip findById(Integer id);

}
