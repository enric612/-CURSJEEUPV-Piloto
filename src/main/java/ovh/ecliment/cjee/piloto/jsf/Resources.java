/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.jsf;

import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author ecliment
 * L'anotació dependent indica que el recurs (classe) dependra del context en
 * el que estiga invocat
 */
@Dependent
public class Resources {

    // Produces es gasta per a generar un objecte que pot ser injectat 
    // Este objecte no es un bean. 
    @Produces
    public Logger getLogger(InjectionPoint p) {
        return Logger.getLogger(p.getMember().getDeclaringClass().getName());
    }

}
