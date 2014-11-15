/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.Memento;

import java.util.Stack;

/**
 *
 * @author pedro_000
 */
abstract class Memento<T> 
{
    private Stack<T> pilha_memento = new Stack<T>();
    public void inserir(T obj)
    {
        pilha_memento.push(obj);
    }
    public T retornar()
    {
        return pilha_memento.peek();
    }
    public T undo()
    {
        if(pilha_memento.size()>0)
            pilha_memento.pop();
        return pilha_memento.peek();
    }
}
