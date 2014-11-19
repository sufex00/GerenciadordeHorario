/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import apresentacao.FormCadastroMateria;
import banco.DAO.BdMateriaDAO;
import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryBdMateria;
import banco.FactoryMetody.FactoryMetody;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objeto.Materia;
import objeto.Turma;

/**
 *
 * @author pedro_000
 */
public class NegocioMateria {
    BdMateriaDAO objBdMateria = new BdMateriaDAO();
    public boolean VerificadorMateria(FormCadastroMateria form, Materia obj_Materia)
    {
        FactoryMetody BdMateria = new FactoryBdMateria();
        InterfaceDAO obj_BdMateria = BdMateria.criar_DAO_BD();
        boolean retorno = true;
        if(form.jTextNome.getText().isEmpty())
        {
            retorno = false;
            form.jLabelNomeErro.setVisible(true);
        }
        
        return retorno;
    }
    public void cadastrar(FormCadastroMateria form_materia)
    {
        String nome = form_materia.jTextNome.getText();
        int horasAulas = Integer.parseInt(form_materia.jTextHorasAula.getText());
        int id = Integer.parseInt(form_materia.jTextId.getText());
        Turma turma = (Turma)form_materia.jComboTurma.getSelectedItem();
        
        String descricao = form_materia.jTextAreaDescricao.getText();
        Materia obj_materia = new Materia(id, nome, descricao, horasAulas,turma.getId());
        NegocioMateria negocioMateria = new NegocioMateria();
        if(this.VerificadorMateria(form_materia, obj_materia))
        {   
            negocioMateria.salvar(form_materia, obj_materia);
            JOptionPane.showMessageDialog(null, "Materia cadastrado com sucesso!!");
            form_materia.preencherTabela();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Materia não cadastrado\nError!!");
        }
    }
     public void buscar(FormCadastroMateria form_materia){
        
        Materia objMateriaSelecionado = null;
        String id = form_materia.jTextFieldBuscaId.getText();
        FactoryMetody BdMateria = new FactoryBdMateria();
        InterfaceDAO objBdMateria = BdMateria.criar_DAO_BD();
        ArrayList<Materia> listMateria = objBdMateria.listar();
        for(Materia objMateria : listMateria)
        {
            if(objMateria.getId()==Integer.parseInt(id))
            {
                objMateriaSelecionado=objMateria;
            }
        }
        if(objMateriaSelecionado!=null)
        {
            form_materia.jTextNome.setText(objMateriaSelecionado.getNome());
            form_materia.jTextId.setText(new Integer(objMateriaSelecionado.getId()).toString());
            form_materia.jTextId.setEditable(false);
            form_materia.jTextAreaDescricao.setText(objMateriaSelecionado.getDescricao());
            form_materia.jTextHorasAula.setText(new Integer(objMateriaSelecionado.getCargahoraria()).toString());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Materia não encontrado!!\nError!");
        }
    }
      public boolean excluir (FormCadastroMateria form_materia)
    {
        BdMateriaDAO obj_Bdmateria = new BdMateriaDAO();
        boolean retorno = false;
        if(form_materia.jTextId.getText().isEmpty() || !form_materia.jTextId.isEditable())
        {
            retorno = obj_Bdmateria.deletar(new Materia(Integer.parseInt(form_materia.jTextId.getText())));            
        }
        return retorno;
    }
      public boolean atualizar(FormCadastroMateria form_Materia){
         
         BdMateriaDAO bdMateria = new BdMateriaDAO();
         String nome = form_Materia.jTextNome.getText();
         String descricao = form_Materia.jTextAreaDescricao.getText();
         int horasAula = Integer.parseInt(form_Materia.jTextHorasAula.getText());
         int id = Integer.parseInt(form_Materia.jTextId.getText());
         Turma turma = (Turma)form_Materia.jComboTurma.getSelectedItem();
         boolean retorno = false;
         
         Materia materia = new Materia(id, nome, descricao, horasAula,turma.getId());
         
         if(this.VerificadorMateria(form_Materia,materia))
        {
            retorno = bdMateria.atualizar(materia);
        }
        return retorno;
               
    }
    public boolean salvar(FormCadastroMateria form_materia, Materia objMateria)
    {
        boolean retorno = false;
                
    if(this.VerificadorMateria(form_materia, objMateria))
    {
        retorno = this.objBdMateria.salvar(objMateria);
    }
       return retorno;
    }
}
