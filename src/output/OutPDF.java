/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus
 */
public class OutPDF {

    private static String fileName = "default.pdf";
    private static String schoolName;
    private static String descricao = "";
    private PdfPTable table;
    private PdfPCell[] cell = new PdfPCell[6];
    private int aux = 0;
    private int dias;

    public OutPDF(int numColumns) {
        this.table = new PdfPTable(numColumns);
        this.dias = numColumns;
        PdfPCell[] cell = new PdfPCell[]{new PdfPCell(Phrase.getInstance("Horário")),
            new PdfPCell(Phrase.getInstance("Segunda")),
            new PdfPCell(Phrase.getInstance("Terça")),
            new PdfPCell(Phrase.getInstance("Quarta")),
            new PdfPCell(Phrase.getInstance("Quinta")),
            new PdfPCell(Phrase.getInstance("Sexta"))};
        PdfPRow row = new PdfPRow(cell);
        table.getRows().add(row);
    }

    public void CreatePDF() throws IOException {
        Document doc = null;
        OutputStream outStream = null;

        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            outStream = new FileOutputStream(fileName);
            PdfWriter.getInstance(doc, outStream);
            doc.open();
            doc.add(new Paragraph(getHeader()));
            doc.add(table);
            doc.add(new Paragraph(descricao));

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(OutPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (outStream != null) {
                outStream.close();
            }
            // table.getRows().add(null)
        }
        JOptionPane.showMessageDialog(null, "PDF Salvo com sucesso!");
    }

    private static String getHeader() {
        String result = schoolName + "\n";
        result += "Horário Curricular Anual\n\n";

        return result;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        OutPDF.fileName = fileName + ".pdf";
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        OutPDF.schoolName = schoolName;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        OutPDF.descricao = "\n\nDescrição:\n"+ descricao;
    }
    
    public void addCell(String str) {
        if (aux == dias) {
            PdfPRow row = new PdfPRow(cell);
            table.getRows().add(row);
            aux = 0;
            cell = new PdfPCell[dias];
        }
        cell[aux] = new PdfPCell(Phrase.getInstance(str));
        aux++;

    }
    public void addCell(ArrayList<String> arr){
        for(String str : arr){
            this.addCell(str);
        }
        this.completeRow();
    }

    public void completeRow() {
        if (aux == 0) {
            JOptionPane.showMessageDialog(null, "Row Completa não hà necessidade de usar metodo!");
        } else {
            while (aux != dias) {
                addCell("--");
            }
            addCell("--");
        }
    }

}
