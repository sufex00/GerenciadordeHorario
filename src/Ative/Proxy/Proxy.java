package Ative.Proxy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author matheus
 */
public class Proxy {

    //private boolean ok;
    private String code = "";
    private String okCode = "";

    public boolean proxyTest(String code) {
        this.code = code.toUpperCase();
        //System.out.println(this.code);
        if (this.code.length() < 20 || this.code.length() > 23) {
            //System.out.println("Codigo Não pode ser processado TAMANHO");
            return false;
        } else if (valide()) {
            //System.out.println("Codigo pode ser processado");
            return true;
        }
        //System.out.println("Codigo Não pode ser processado OUTROS");
        return false;
    }

    public String getCode() {
        return okCode;
    }

    private boolean valide() {

        if (code.charAt(5) == '-' && code.charAt(11) == '-' && code.charAt(17) == '-' && isOk(code)) {
            okCode = code;
            return true;
        } else {
            //System.out.println("Entrou aqui");
            for (int i = 0, j = 0; i < code.length(); ++i, ++j) {
                okCode += code.charAt(i);
                if (j == 4 && i != code.length() - 1 && code.charAt(i + 1) != '-') {
                    okCode += '-';
                    j = -1;
                }
            }
            if (isOk(okCode)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOk(String str) {
        String modolo = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM-";
        String aux = "";
        //System.out.println(str);
        for (int i = 0; i < str.length(); ++i) {
            aux += str.charAt(i);
            //System.out.println(aux);
            if (!modolo.contains(aux)) {
                return false;
            }
            aux = "";

        }

        return true;
    }

}

//MATH3-P3DR0-4NDR3-1C0N3
//MATH3P3DR04NDR31C0N3
