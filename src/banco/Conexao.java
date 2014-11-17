
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {

    Connection conexao;
    public Connection getConnection() {
        
        try {
            String stringConexao = "jdbc:postgresql://localhost:5432/";
            String nomeBanco = "gerenciador";
            String usuarioBanco = "postgres";
            String senhaBanco = "senha";

            Class.forName("org.postgresql.Driver");

            conexao = DriverManager.getConnection(stringConexao + nomeBanco,
                    usuarioBanco, senhaBanco);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            conexao = null;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            conexao = null;
        }
        return conexao;
    }
    public void close() throws SQLException
    {
        conexao.close();
    }

}
