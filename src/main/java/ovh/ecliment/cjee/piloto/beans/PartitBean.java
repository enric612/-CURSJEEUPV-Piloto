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
    
    public Partit getPartit(){
        return this.partit;
    }
    
    public void setPartit(Partit partit){
        this.partit = partit;
    }
    
    private List<Partit> llistaDePartits;
    
    public List<Partit> getLlistaDePartits(){
        if(this.llistaDePartits==null){
            this.llistaDePartits=DAOFactory.getPartitDAO().findAll();
        }
        return this.llistaDePartits;
    }
    
    public void setLlistaDePartits(List<Partit> partits){
        this.llistaDePartits = partits;
    }
    
    
}
