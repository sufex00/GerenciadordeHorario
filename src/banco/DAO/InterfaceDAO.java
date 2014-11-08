/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.DAO;

import java.util.ArrayList;

/**
 *
 * @author pedro_000
 */
public interface InterfaceDAO<T> {
    
    public boolean salvar(T objeto);
    public boolean deletar(String cpf);
    public ArrayList<T> listar();
    public T procurar(String cpf);
}
