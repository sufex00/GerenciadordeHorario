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
public interface OutPDFBuilder {

    public OutPDF getBuilder();

    public void buildNameFile();

    public void buildNameSchool();

    public void buildDescricao();
}
