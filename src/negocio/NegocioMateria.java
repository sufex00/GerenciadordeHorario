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
import objeto.Materia;

/**
 *
 * @author pedro_000
 */
public class NegocioMateria {
    
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
        if(retorno)
        {
            retorno = obj_BdMateria.salvar(obj_Materia);
        }
        return retorno;
    }
}
