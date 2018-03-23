/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.jsf;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

/**
 *
 * @author ecliment
 */
@FacesConfig(
// Activem els beans de CDI
version = JSF_2_3
)
@ApplicationScoped
public class ConfigurationBean {
    
}
