/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

/**
 *
 * @author pedro_000
 */
public class HorarioEscolar {
    
    private DiaEscolar[] dia_Escolar;
    private int idTurma;
    private int num;
    
    public HorarioEscolar(int num)
    {
        this.dia_Escolar = new DiaEscolar [num];
        this.num=num;
    }
    
    public void setDiaEscolar(int indice, DiaEscolar dia_Escolar)
    {
        this.dia_Escolar[indice] = dia_Escolar;
    }
    
    public DiaEscolar[] getDiaEscolar()
    {
        return this.dia_Escolar;
    }
    
    public DiaEscolar getDiaEscolar(int indice)
    {
        return this.dia_Escolar[indice];
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
   
}
