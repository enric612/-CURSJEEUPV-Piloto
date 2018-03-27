/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import ovh.ecliment.cjee.piloto.dao.DAOFactory;
import ovh.ecliment.cjee.piloto.domini.Equip;

/**
 *
 * @author ecliment
 */
@Named
@SessionScoped
public class LligaBean implements Serializable {

    private static final long serialVersionUID = 2120846723985061940L;

    private String[] jornades;
    private int numJornades = 38;

    public String[] getJornades() {
        if (jornades == null) {
            jornades = new String[numJornades];
            for (int i = 0; i < numJornades; i++) {
                jornades[i] = String.valueOf(i + 1);
            }
        }
        return jornades;
    }

    public void setJornades(String[] jornades) {
        this.jornades = jornades;
    }

    private List<Equip> equips;

    public List<Equip> getEquips() {
        if (this.equips == null) {
            this.equips = DAOFactory.getEquipDAO().findAll();
        }
        return equips;
    }
    
    public void setEquips(List<Equip> equips){
        this.equips = equips;
    }

}
