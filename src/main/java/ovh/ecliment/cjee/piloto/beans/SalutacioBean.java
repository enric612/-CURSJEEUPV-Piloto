/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ecliment
 */
@Named
@SessionScoped
public class SalutacioBean implements Serializable {

    private static final long serialVersionUID = 3091677078165353125L;

    private String salutacio = "Hola Usuari";

    public String getSalutacio() {
        return salutacio;
    }

    public void setSalutacio(String salutacio) {
        this.salutacio = salutacio;
    }

}
