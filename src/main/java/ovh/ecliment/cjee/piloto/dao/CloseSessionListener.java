/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ovh.ecliment.cjee.piloto.dao;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author ecliment
 */
public class CloseSessionListener implements PhaseListener {

    public void afterPhase(PhaseEvent event) {
        if (HibernateUtil.getSession() != null) {
            HibernateUtil.closeSession();
        }
    }

    public void beforePhase(PhaseEvent event) {
        // TODO Auto-generated method stub
    }

    public PhaseId getPhaseId() {
        // TODO Auto-generated method stub
        return PhaseId.RENDER_RESPONSE;
    }

}
