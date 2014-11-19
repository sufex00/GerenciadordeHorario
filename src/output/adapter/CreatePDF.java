/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output.adapter;

import java.util.ArrayList;
import objeto.HorarioEscolar;

/**
 *
 * @author matheus
 */
public interface CreatePDF {
    
    public void loading(HorarioEscolar horario);
    public ArrayList<String> get();
    
}
