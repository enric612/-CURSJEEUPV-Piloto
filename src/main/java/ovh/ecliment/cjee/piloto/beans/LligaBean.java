/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.beans;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
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
    // ATENCIÓ PROFESOR:
    // No entenc quina ventaja te inicialitzar este valor desde un xml...
    // Es pot fer si, pero estem en 2018 i els xml quan menys els gastem 
    // desde el meu punt de vista millor.
    // Si es veritat que cal recompilar l'aplicació pero editar un xml 
    // dins de un war tampoc es que siga lo mes òptim, hui en dia
    // compilar una app com esta o mes gran es mes rapid que editar manualment
    // un xml dins de un paquet i mes si es gaste eines com maven/gradle.    
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
