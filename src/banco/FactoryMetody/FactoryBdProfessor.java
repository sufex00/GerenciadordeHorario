/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.FactoryMetody;

import banco.DAO.BdProfessorDAO;
import banco.DAO.InterfaceDAO;
import objeto.Professor;

/**
 *
 * @author pedro_000
 */
public class FactoryBdProfessor implements FactoryMetody{

    @Override
    public InterfaceDAO criar_DAO_BD() {
       return new BdProfessorDAO();
    }
    
}
