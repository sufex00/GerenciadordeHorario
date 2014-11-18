/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

/**
 *
 * @author matheus
 */
public class Codigo {
    private String ico_codigo;
    private String ico_email;
    private int ico_level;

    public Codigo(String ico_code, String ico_email, int ico_level) {
        this.ico_codigo = ico_code;
        this.ico_email = ico_email;
        this.ico_level = ico_level;
    }

    public String getIco_code() {
        return ico_codigo;
    }

    public void setIco_code(String ico_codigo) {
        this.ico_codigo = ico_codigo;
    }

    public String getIco_email() {
        return ico_email;
    }

    public void setIco_email(String ico_email) {
        this.ico_email = ico_email;
    }

    public int getIco_level() {
        return ico_level;
    }

    public void setIco_level(int ico_level) {
        this.ico_level = ico_level;
    }
    
    
    
}
