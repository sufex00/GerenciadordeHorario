/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ative.FactoryMetody;

import Ative.DB.DAO.BDCodigoDAO;
import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryMetody;

/**
 *
 * @author matheus
 */
public class FactoryDbCodigo implements FactoryMetody{

    @Override
    public InterfaceDAO criar_DAO_BD() {
        return new BDCodigoDAO();
    }
    
}
