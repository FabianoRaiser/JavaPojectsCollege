import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClasseConexao {
	
	private static Connection conexao = null;
	public static Connection Conectar()
		{
			try
			{
				if(conexao==null)
				{
					// É sempre o nome da DB e não da tabela!
					String url = "jdbc:mysql://localhost/funcionarios";
					conexao = DriverManager.getConnection(url,"root","");
					
				}
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
			return conexao;
		}
		
		public static void FecharConexao(Connection c)
		{
			try
			{
				if(c != null)
				{
					c.close();
					conexao = null;
				}
			}catch(SQLException erro)
			{
				erro.printStackTrace();
			}
		}

}
