/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Marcos
 */
public class Conexao {

    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vraptor_sessao", "root", "");            
        } catch (Exception e) {
            System.out.println("Falha na conexão");
            e.printStackTrace();
        }
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fechar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
            }
        }
    }

}
