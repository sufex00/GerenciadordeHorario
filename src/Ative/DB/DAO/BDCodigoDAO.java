/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ative.DB.DAO;

import Ative.DB.Connect;
import banco.DAO.InterfaceDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.Codigo;

/**
 *
 * @author matheus
 */
public class BDCodigoDAO implements InterfaceDAO<Codigo> {

    public boolean salvar(Codigo objCodigo) {
        return false;
    }

    @Override
    public ArrayList<Codigo> listar() {
        Connect conexao = new Connect();
        String sql = "SELECT * FROM ico_code;";
        ArrayList<Codigo> listCodigo = new ArrayList<>();
        try {
            PreparedStatement pc = conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while (objResultSet.next()) {
                String code = objResultSet.getString("ico_codigo");
                String email = objResultSet.getString("ico_email");
                int level = objResultSet.getInt("ico_level");
                Codigo objCodigo = new Codigo(code, email, level);
                listCodigo.add(objCodigo);
            }
            conexao.getConnection().close();
            return listCodigo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean deletar(Codigo obj_code) {
        return false;
    }

    @Override
    public Codigo procurar(Codigo looking) {
        ArrayList<Codigo> list = this.listar();
        Codigo obj_retorno = null;
        for (Codigo obj_codigo : list) {
            if (obj_codigo.getIco_code().equals(looking.getIco_code())) {
                obj_retorno = obj_codigo;
            }
        }
        return obj_retorno;
    }

    @Override
    public boolean atualizar(Codigo obj_code) {
        return false;
    }

}
