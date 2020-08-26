/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conf.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

/**
 *
 * @author Marcos
 */
public class UsuarioDAO {

    private Conexao c;
    private Statement stmt;
    private PreparedStatement ps;

    public UsuarioDAO() {
        c = new Conexao();
    }

    public List listar() {
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            String SQL = "Select * from usuario";

            stmt = c.getConexao().createStatement();

            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Usuario u = new Usuario();

                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));

                lista.add(u);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public Usuario listarPorId(String id) {
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            String SQL = "Select * from usuario where id = " + id;

            stmt = c.getConexao().createStatement();

            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public void adicionar(Usuario usuario) throws SQLException {
        try {
            String SQL = "INSERT INTO usuario(nome, login, senha) "
                    + "VALUES (?, ?, md5(?))";

            ps = c.getConexao().prepareStatement(SQL);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());

            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
        }
    }

    public void editar(Usuario usuario) throws SQLException {
        try {
            String SQL = "UPDATE usuario SET "
                    + "nome= ?, login=? "
                    + "WHERE id=?";

            ps = c.getConexao().prepareStatement(SQL);

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setLong(3, usuario.getId());

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ps.close();
        }
    }

    public void excluir(String id) {
        try {
            String SQL = "DELETE FROM usuario WHERE id=" + id;

            stmt = c.getConexao().createStatement();

            stmt.executeUpdate(SQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Usuario autenticar(String login, String senha) {
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            String SQL = "select * from usuario where login = ? and senha=md5(?)";   
            
            ps = c.getConexao().prepareStatement(SQL);

            ps.setString(1, login);
            ps.setString(2, senha);
                        
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

}
