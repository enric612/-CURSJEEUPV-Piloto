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
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
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
public class PartitBean implements Serializable {

    private static final long serialVersionUID = 2467055050267808697L;
    @ManagedProperty(value = "#{partit}")
    private Partit partit;
    private List<Partit> llistaDePartits;
    private String equip;
    private String selectedPartit;

    public String getSelectedPartit() {
        return this.selectedPartit;
    }

    public void setSelectedPartit(String selectedPartit) {
        this.selectedPartit = selectedPartit;
    }

    // JSF 2.3  + CDI 2.0 Gracies!!
    /*
    @Inject
    private FacesContext facesContext;*/
    // Per poder accedir directament sense passar per llistaPartits.xhtml
    @PostConstruct
    public void init() {
        //crearPartit(); // Si activem la propietat @ManagePrpoperty es pot comentar
    }

    /* CRUD */
    private void crearPartit() {
        partit = new Partit();
    }

    public Partit getPartit() {
        return this.partit;
    }

    public void setPartit(Partit partit) {
        this.partit = partit;
    }

    public List<Partit> getLlistaDePartits() {
        this.llistaDePartits = DAOFactory.getPartitDAO().findAll();      
        return this.llistaDePartits;
    }

    public void setLlistaDePartits(List<Partit> partits) {
        this.llistaDePartits = partits;
    }

    private void filtrarPerJornada(String jornada) {
        if (jornada.equals("Totes")) {
            llistaDePartits = DAOFactory.getPartitDAO().findAll();
        } else {
            llistaDePartits = DAOFactory.getPartitDAO().findByJornada(jornada);
        }      
    }

    public String getEquip() {
        return this.equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    private void filtrarPerEquip() {
        if (equip.trim().length() == 0) {
            llistaDePartits = DAOFactory.getPartitDAO().findAll();
        } else {
            llistaDePartits = DAOFactory.getPartitDAO().findByEquip(equip);
        }
    }

    private void guardar() {
        DAOFactory.getPartitDAO().save(partit);
    }

    /* LISTENERS */
    public void crearPartitListener(ActionEvent ae) {
        crearPartit();
    }

    public void filtrarListener(ValueChangeEvent ve) {
        filtrarPerJornada((String) ve.getNewValue());
    }

    public void filtrarPerEquipListener(ActionEvent ae) {
        filtrarPerEquip();
    }

    public void guardarListener(ActionEvent ae) {
        guardar();
    }

    public void eliminar(ActionEvent e) {
        String partitID = null;
        partitID = (String) FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap()
                .get("selectedPartit");

        Partit p = DAOFactory.getPartitDAO().findById(Integer.valueOf(partitID));
        DAOFactory.getPartitDAO().remove(p);
    }

    public void actualitzar() {
        if (selectedPartit == null) {
            crearPartit();
        } else {
            partit = DAOFactory.getPartitDAO()
                    .findById(Integer.valueOf(selectedPartit));
        }
    }

}
