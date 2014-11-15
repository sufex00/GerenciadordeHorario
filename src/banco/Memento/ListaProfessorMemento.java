/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Memento;

import java.util.ArrayList;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class ListaProfessorMemento extends Memento<ArrayList<Professor>>{
    

    public Professor desfazer()
    {
        Professor obj_retorno=null;
        ArrayList<Professor> list_undo = new ArrayList<Professor>(super.undo());
        for(Professor obj_professor : list_undo)
        {
            if(!super.retornar().contains(obj_professor))
            {
                obj_retorno = obj_professor;
            }
        }
        return obj_retorno;
    }
    
}
