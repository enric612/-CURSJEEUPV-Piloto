/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.convertidors;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import ovh.ecliment.cjee.piloto.dao.DAOFactory;
import ovh.ecliment.cjee.piloto.domini.Equip;

/**
 *
 * @author ecliment
 */
@FacesConverter("String2Equip")
public class String2EquipConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Equip equip = DAOFactory.getEquipDAO().findById(Integer.parseInt(string));
        
        return equip;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        return t.toString();
    }
    
}
