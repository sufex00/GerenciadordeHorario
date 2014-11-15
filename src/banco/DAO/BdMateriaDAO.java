/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;


import banco.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objeto.*;

/**
 *
 * @author pedro_000
 */
public class BdMateriaDAO implements InterfaceDAO<Materia>{
        
        public boolean salvar(Materia objMateria){
        Conexao conexao = new Conexao();
        String sql="INSERT INTO materia (id, nome, descricao, cargahoraria"
                + ") VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, objMateria.getId());
            pc.setString(2, objMateria.getNome());
            pc.setString(3, objMateria.getDescricao());
            pc.setInt(4, objMateria.getCargahoraria());
            
            pc.execute();
            conexao.getConnection().close();
            return true;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
        
        }
        public ArrayList<Materia> listar(){
        Conexao conexao = new Conexao();
        String sql="SELECT * FROM materia;";
        ArrayList<Materia> listMateria = new ArrayList<Materia>();
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            ResultSet objResultSet = pc.executeQuery();
            while(objResultSet.next())
            {
                int id = objResultSet.getInt("id");
                String nome = objResultSet.getString("nome");
                String descricao = objResultSet.getString("descricao");
                int cargaHoraria = objResultSet.getInt("cargahoraria");
                Materia obj_materia = new Materia (id, nome, descricao, cargaHoraria);
                listMateria.add(obj_materia);
            }
            conexao.getConnection().close();
            return listMateria;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deletar(Materia obj_materia) {
         Conexao conexao = new Conexao();
        String sql="DELETE FROM materia WHERE id=?";
        try{
            PreparedStatement pc=conexao.getConnection().prepareStatement(sql);
            pc.setInt(1, obj_materia.getId());
            pc.execute();
            conexao.getConnection().close();
            return true;
        }catch(SQLException ex) {
           ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Materia procurar(Materia id) {
        ArrayList<Materia> list = this.listar();
        Materia obj_retorno = null;
        for(Materia obj_materia : list)
        {
            if(obj_materia.getId()==id.getId())
            {
                obj_retorno = obj_materia;
            }
        }
        return obj_retorno;
    }

    @Override
    public void trocar(Materia objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
