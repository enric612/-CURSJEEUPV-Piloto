/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import ovh.ecliment.cjee.piloto.dao.DAOFactory;
import ovh.ecliment.cjee.piloto.dao.HibernateUtil;
import ovh.ecliment.cjee.piloto.domini.Partit;

/**
 *
 * @author ecliment
 */
@Named
@SessionScoped
public class PartitBean implements Serializable{
    
    private static final long serialVersionUID = 2467055050267808697L;
    private Partit partit;
    private List<Partit> llistaDePartits;
    private String equip;
    
    // Per poder accedir directament sense passar per llistaPartits.xhtml
    @PostConstruct
    public void init() {
        crearPartit();
    }
        
    /* CRUD */
    private void crearPartit(){
        partit = new Partit();
    }     
    
    public Partit getPartit(){
        return this.partit;
    }
    
    public void setPartit(Partit partit){
        this.partit = partit;
    }   
        
    public List<Partit> getLlistaDePartits(){
        this.llistaDePartits=DAOFactory.getPartitDAO().findAll();     
        return this.llistaDePartits;
    }
    
    public void setLlistaDePartits(List<Partit> partits){
        this.llistaDePartits = partits;
    }
    
    private void filtrarPerJornada(String jornada){
        if(jornada.equals("Totes"))
            llistaDePartits=DAOFactory.getPartitDAO().findAll();
        else
            llistaDePartits=DAOFactory.getPartitDAO().findByJornada(jornada);
    }
    
    public String getEquip(){
        return this.equip;
    }
    
    public void setEquip(String equip){
        this.equip = equip;
    }
    
    private void filtrarPerEquip(){
        if(equip.trim().length()==0)
            llistaDePartits = DAOFactory.getPartitDAO().findAll();
        else
            llistaDePartits = DAOFactory.getPartitDAO().findByEquip(equip);
    }
    
    private void guardar(){       
        DAOFactory.getPartitDAO().save(partit);        
    }
    
    /* LISTENERS */
    
    public void crearPartitListener(ActionEvent ae){
        crearPartit();
    }
    
    public void filtrarListener(ValueChangeEvent ve){
        filtrarPerJornada((String)ve.getNewValue());
    }
    
    public void filtrarPerEquipListener(ActionEvent ae){
        filtrarPerEquip();
    }
    
    public void guardarListener(ActionEvent ae){
        guardar();        
    }
    
    
    
}
