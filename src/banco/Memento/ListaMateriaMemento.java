/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Memento;

import java.util.ArrayList;
import objeto.Materia;

/**
 *
 * @author pedro_000
 */
public class ListaMateriaMemento extends Memento<ArrayList<Materia>>{
    
        public Materia desfazer()
    {
        Materia obj_retorno=null;
        ArrayList<Materia> list_undo = new ArrayList<Materia>(super.undo());
        for(Materia obj_materia : list_undo)
        {
            if(!super.retornar().contains(obj_materia))
            {
                obj_retorno = obj_materia;
            }
        }
        return obj_retorno;
    }
    
}
