import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Inserir {

	public static void main(String[] args) {
		// Arquivo para INSERIR dados numa tabela
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "INSERT into contatos(cpf,nome) VALUES(?,?,?)";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					String cpf = JOptionPane.showInputDialog("CPF:");
					String nome = JOptionPane.showInputDialog("NOME:");
					String idade = JOptionPane.showInputDialog("IDADE:");
					
					comando.setString(1, cpf);
					comando.setString(2, nome);
					comando.setString(3, idade);
					
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS GRAVADOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}

	}

}
