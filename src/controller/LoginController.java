/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import util.UserSession;
import dao.UsuarioDAO;
import model.Usuario;
import util.Public;

/**
 *
 * @author marcos
 */
@Resource
public class LoginController {
    
    private Result result;
    private UsuarioDAO usuarioDAO;
    private UserSession userSession;

    public LoginController(Result result, UsuarioDAO usuarioDAO, UserSession userSession) {
        this.result = result;
        this.usuarioDAO = usuarioDAO;
        this.userSession = userSession;
    }
    
    @Public
    @Path("/login")
    public void login(){
        
    }
    
    @Public
    @Path("/autenticar")
    public void autenticar(Usuario usuario){
        Usuario u = usuarioDAO.autenticar(usuario.getLogin(), usuario.getSenha());
        
        if (u != null){
            userSession.setUsuario(u);
            
            result.redirectTo(IndexController.class).index();
        }else{
            result.include("error", "Login ou senha incorretos!").redirectTo(this).login();
        }
    }
    
    @Path("/logout")
    public void logout(){
        userSession.logout();
        result.redirectTo(this).login();
    }
    
}
