/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ative.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class Connect {
     public Connection getConnection() {
        Connection conexao;
        try {
            String stringConexao = "jdbc:mysql://sql8.hostinger.com.br/";
            String nomeBanco = "u642109495_proxy";
            String usuarioBanco = "u642109495_proxy";
            String senhaBanco = "matheus23";

            Class.forName("com.mysql.jdbc.Driver");

            conexao = DriverManager.getConnection(stringConexao+nomeBanco,
                    usuarioBanco, senhaBanco);
            //JOptionPane.showMessageDialog(null, "Banco Online");

        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Verifique sua conexão à internet");
            JOptionPane.showMessageDialog(null, e.getMessage());
            //System.out.println(e.getMessage());
            conexao = null;
        }
        
        return conexao;
    }
}
