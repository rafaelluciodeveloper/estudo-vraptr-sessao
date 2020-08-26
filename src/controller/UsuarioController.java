/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Marcos
 */
@Resource
public class UsuarioController {
    
    private final Result result;
    private final UsuarioDAO usuarioDAO;

    public UsuarioController(Result result, UsuarioDAO usuarioDAO) {
        this.result = result;
        this.usuarioDAO = usuarioDAO;
    }

    @Path("/usuarios")
    public List<Usuario> index() {
        return usuarioDAO.listar();
    }
    
    @Path("/usuarios/adicionar")
    public void adicionar() {
        
    }
    
    @Path("/usuarios/salvar")
    public void salvar(Usuario usuario){        
        try {        
            usuarioDAO.adicionar(usuario);
            result.include("mensagem", "Dados Salvos com Sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }        
    
    @Path("/usuarios/editar/{id}")
    public Usuario editar(String id) {       
        return usuarioDAO.listarPorId(id);
    }
    
    @Path("/usuarios/atualizar")
    public void atualizar(Usuario usuario){        
        try {        
            usuarioDAO.editar(usuario);
            result.include("mensagem", "Dados Atualizados com Sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Path("/usuarios/excluir/{id}")
    public void excluir(String id) {
        usuarioDAO.excluir(id);
        result.include("mensagem", "Dados Excluídos com Sucesso!");
    }
    
}