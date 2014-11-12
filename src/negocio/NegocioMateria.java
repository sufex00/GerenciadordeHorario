/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import apresentacao.FormCadastroMateria;
import banco.BdMateria;
import objeto.Materia;

/**
 *
 * @author pedro_000
 */
public class NegocioMateria {
    
    public boolean VerificadorMateria(FormCadastroMateria form, Materia obj_Materia)
    {
        BdMateria obj_BdMateria = new BdMateria();
        boolean retorno = true;
        if(form.jTextNome.getText().isEmpty())
        {
            retorno = false;
            form.jLabelNomeErro.setVisible(true);
        }
        if(retorno)
        {
            retorno = obj_BdMateria.InserirMateria(obj_Materia);
        }
        return retorno;
    }
}
