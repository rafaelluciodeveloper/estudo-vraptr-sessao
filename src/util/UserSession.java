/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import model.Usuario;

/**
 *
 * @author marcos
 */
@Component
@SessionScoped
public class UserSession {
    
    private Usuario usuario;
    
    public boolean isLogged(){
        return usuario != null;
    }
    
    public void logout(){
        usuario = null;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }        
    
}