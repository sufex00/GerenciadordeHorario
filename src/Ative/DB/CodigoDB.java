/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ative.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.Codigo;

/**
 *
 * @author matheus
 */
public class CodigoDB {

    private ArrayList<Codigo> SelecionarListProfessor() {
        Connect conexao = new Connect();
        String sql = "SELECT * FROM ico_code;";
        ArrayList<Codigo> listProfessor = new ArrayList<>();
        try {
            PreparedStatement pc = conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while (objResultSet.next()) {
                String code = objResultSet.getString("ico_codigo");
                String email = objResultSet.getString("ico_email");
                int level = objResultSet.getInt("ico_level");
                Codigo objCode = new Codigo(code, email, level);
                listProfessor.add(objCode);
            }
            conexao.getConnection().close();
            return listProfessor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean exist(String key) {
        ArrayList<Codigo> list = SelecionarListProfessor();
        for (Codigo co : list) {
            if(co.getIco_code().equals(key)){
                return true;
            }
        }
        return false;
    }

}
