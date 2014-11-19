/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output.builder;

import output.OutPDF;

/**
 *
 * @author matheus
 */
public class SabadoBuilder implements OutPDFBuilder {

    private OutPDF out;

    public void SabadoBuilder() {
        out = new OutPDF(7);
    }

    @Override
    public void buildNameFile() {
        out.setFileName("default");
    }

    @Override
    public void buildNameSchool() {
        out.setSchoolName("Badu School");
    }

    @Override
    public void buildDescricao() {
        out.setDescricao("");
    }

    @Override
    public OutPDF getBuilder() {
        return out;
    }

}
