/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.FactoryMetody;

import banco.DAO.BdTurmaDAO;
import banco.DAO.InterfaceDAO;
import java.util.ArrayList;

/**
 *
 * @author pedro_000
 */
public class FactoryBdTurma implements FactoryMetody{
    @Override
    public InterfaceDAO criar_DAO_BD() {
       return new BdTurmaDAO();
    }

}
