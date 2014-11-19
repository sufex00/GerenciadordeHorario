/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output.adapter;

import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryBdMateria;
import banco.FactoryMetody.FactoryMetody;
import java.util.ArrayList;
import objeto.HorarioEscolar;
import objeto.Materia;

/**
 *
 * @author matheus
 */
public class Create implements CreatePDF{
    ArrayList<String> cellList = new ArrayList<>();
    @Override
    public void loading(HorarioEscolar horario) {
        FactoryMetody factoryBD = new FactoryBdMateria();
        InterfaceDAO interfaceBD = factoryBD.criar_DAO_BD();
        for (int i = 0; i < horario.getNum(); i++) {
            for (int j = 0; j < horario.getDiaEscolar(i).getNumMateria(); j++) {
                Materia obMateria = (Materia) interfaceBD.
                        procurar(new Materia(horario.getDiaEscolar(i).getMateria(j)));
                cellList.add(obMateria.getNome());
            }
        }

    }

    @Override
    public ArrayList<String> get() {
        for (int i = 0,j = 0; i < cellList.size()/7; i+=7,j++) {
            cellList.add(i, "Aula "+Integer.toString(j));
        }        
       return cellList;
    }
    
}
