/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.jsf;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import ovh.ecliment.cjee.piloto.dao.DAOFactory;
import ovh.ecliment.cjee.piloto.dao.PartitDAO;
import ovh.ecliment.cjee.piloto.domini.Partit;

/**
 *
 * @author ecliment
 */
@Named
@RequestScoped
public class HelloBean {

    private String message;
    private PartitDAO pdao;
    private List<Partit> partits;

    @PostConstruct
    public void init() {
        partits = new ArrayList<Partit>();
        pdao = DAOFactory.getPartitDAO();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sayHi() {
        this.message = this.message + " received at " + LocalDateTime.now();
    }

    public void getAllPartits() {

        this.partits = pdao.findAll();
    }

    public void getByEquip(String e) {

        this.partits = pdao.findByEquip(e);
    }

    public void getBySimilarEquip(String e) {

        this.partits = pdao.findBySimilarEquip(e);
    }
    
    public void getByJornada(String jornada){
        this.partits = pdao.findByJornada(jornada);
    }

    public List<Partit> getPartits() {

        return this.partits;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.message);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HelloBean other = (HelloBean) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }

}
