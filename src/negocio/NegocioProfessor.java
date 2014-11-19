
package negocio;

import apresentacao.FormCadastroProfessor;
import banco.DAO.BdProfessorDAO;
import banco.DAO.InterfaceDAO;
import banco.FactoryMetody.FactoryBdMateria;
import banco.FactoryMetody.FactoryMetody;
import banco.Memento.ListaProfessorMemento;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objeto.Materia;
import objeto.Professor;

public class NegocioProfessor {
    BdProfessorDAO objBdProfessor = new BdProfessorDAO();

    public boolean VerificadorProfessor(FormCadastroProfessor objForm ,Professor objProfessor){
        
        String MensagemErro;
        boolean retorno=true;
        if(objProfessor.getNome().isEmpty()) {
            retorno = false;
            objForm.jLabelNomeErro.setVisible(true);
        }
        if(objProfessor.getEmail().isEmpty()){
            retorno =  false;
            objForm.jLabelEmailErro.setVisible(true);
        }
       
        if(objProfessor.getCpf().length()<2 || !VerificadorCPF(objProfessor.getCpf()))
        {
            retorno = false;
            objForm.jLabelCpfErro.setVisible(true);
        }
        return retorno;
        
    }
    static public boolean VerificadorCPF (String strCpf )
   {
      int     d1, d2;
      int     digito1, digito2, resto;
      int     digitoCPF;
      String  nDigResult;

      d1 = d2 = 0;
      digito1 = digito2 = resto = 0;

      for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
      {
         digitoCPF = Integer.valueOf (strCpf.substring(nCount -1, nCount)).intValue();

         //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
         d1 = d1 + ( 11 - nCount ) * digitoCPF;

         //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
         d2 = d2 + ( 12 - nCount ) * digitoCPF;
      };

      //Primeiro resto da divisão por 11.
      resto = (d1 % 11);

      //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
      if (resto < 2)
         digito1 = 0;
      else
         digito1 = 11 - resto;

      d2 += 2 * digito1;

      //Segundo resto da divisão por 11.
      resto = (d2 % 11);

      //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
      if (resto < 2)
         digito2 = 0;
      else
         digito2 = 11 - resto;

      //Digito verificador do CPF que está sendo validado.
      String nDigVerific = strCpf.substring (strCpf.length()-2, strCpf.length());

      //Concatenando o primeiro resto com o segundo.
      nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

      //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
      return nDigVerific.equals(nDigResult);
   }
    public static boolean verificadorEmail(String email)
    {
        return email.matches("([A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+)") ;
    }
    public boolean excluir(FormCadastroProfessor form_professor)
    {
        BdProfessorDAO obj_Bdprofessor = new BdProfessorDAO();
        boolean retorno=false;
        if(form_professor.jTextCpf.getText().isEmpty() || !form_professor.jTextCpf.isEditable())
        {
            retorno = obj_Bdprofessor.deletar(new Professor( form_professor.jTextCpf.getText()));            
        }
        return retorno;
    }
    
    public void preencherCombobox(FormCadastroProfessor form_professor){
        FactoryMetody BdMateria = new FactoryBdMateria();
        InterfaceDAO obj_BdMateria = BdMateria.criar_DAO_BD();
        
        ArrayList<Materia> lista = obj_BdMateria.listar();
        
        for(Materia obj_materia: lista){
            form_professor.jComboBoxMaterias.addItem(obj_materia);
           
        }
        
}   
    public boolean salvar(FormCadastroProfessor form_cadastro, Professor ObjProfessor){
      boolean retorno = false;
                
    if(this.VerificadorProfessor(form_cadastro, ObjProfessor))
    {
        retorno = this.objBdProfessor.salvar(ObjProfessor);
    }
       return retorno;
    }
    public void cadastrar(FormCadastroProfessor form_professor)
    {
        form_professor.limparCampos();
        String nome = form_professor.jTextNome.getText();

        String email = form_professor.jTextEmail.getText();
        String cpf = form_professor.jTextCpf.getText();
        Materia idmateria = (Materia)form_professor.jComboBoxMaterias.getSelectedItem();
        int id = idmateria.getId();
       
        
        Professor objProfessor = new Professor(nome, email, cpf,id );
        NegocioProfessor objNegocioCliente = new NegocioProfessor();
        if(objNegocioCliente.VerificadorProfessor(form_professor, objProfessor))
        {   
            objNegocioCliente.salvar(form_professor, objProfessor);
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!!");
            form_professor.preencherTabela();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Professor não cadastrado\nError!!");
        }
        
    }
    
    public boolean atualizar(FormCadastroProfessor form_professor){
        
        BdProfessorDAO obj_BdProfessor = new BdProfessorDAO();
        String cpf = form_professor.jTextCpf.getText();
        String email = form_professor.jTextEmail.getText();
        String nome = form_professor.jTextNome.getText();
        boolean retorno = false;
        
        Materia objMateria = (Materia)form_professor.jComboBoxMaterias.getSelectedItem();
        int id = objMateria.getId();
        Professor nProfessor = new Professor(nome, email, cpf, id);
        if(this.VerificadorProfessor(form_professor,nProfessor))
        {
            retorno = obj_BdProfessor.atualizar(nProfessor);
        }
                             
        return retorno;
    }
    
    
}
