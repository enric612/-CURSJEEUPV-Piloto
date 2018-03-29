/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.validadors;

import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author ecliment
 */
@FacesValidator("dateValidator")
public class DateValidator implements Validator{
    
    @Override
    public void validate(FacesContext fc, UIComponent uic, Object obj)
            throws ValidatorException {
        
        Date data = (Date) obj;
                  
        if(data.compareTo(new Date()) < 0){
            FacesMessage msg = new FacesMessage(
                        "Error de validació: la data deu ser posterior a hui"
                    );
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
         
    }
    
}
