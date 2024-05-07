import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Cadastro {

	private JFrame frame;
	private JTextField CPF_INPUT;
	private JTextField NOME_INPUT;
	private JTextField IDADE_INPUT;
	private JTable table_listagem;
	
	public void Selecionando()
	{
		// Precisamos criar algumas variáveis para conectar, dar comandos e
		// também para armazenar a pesquisa com o SELECT:
		Connection conexao = null;
		Statement  comando = null;
		ResultSet  resultado = null;
		try {
			conexao = ClasseConexao.Conectar();
			comando = conexao.createStatement();
			String meu_sql = "SELECT * FROM contatos";
			resultado = comando.executeQuery(meu_sql); // Executa o SQL
			
// O nome da sua jTable deve ser “tabela_listagem”
			table_listagem.setModel(DbUtils.resultSetToTableModel(resultado));
// O DbUtils deve ser importado (java.sql)
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ClasseConexao.FecharConexao(conexao);
			try
			{
				comando.close();
				resultado.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}		
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 356, 411);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cpfLabel.setBounds(10, 41, 46, 14);
		frame.getContentPane().add(cpfLabel);
		
		JLabel nomeLabel = new JLabel("NOME:");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nomeLabel.setBounds(10, 82, 46, 14);
		frame.getContentPane().add(nomeLabel);
		
		JLabel idadeLabel = new JLabel("IDADE:");
		idadeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idadeLabel.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(idadeLabel);
		
		CPF_INPUT = new JTextField();
		CPF_INPUT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CPF_INPUT.setBounds(50, 40, 107, 20);
		frame.getContentPane().add(CPF_INPUT);
		CPF_INPUT.setColumns(10);
		
		NOME_INPUT = new JTextField();
		NOME_INPUT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NOME_INPUT.setColumns(10);
		NOME_INPUT.setBounds(66, 81, 217, 20);
		frame.getContentPane().add(NOME_INPUT);
		
		IDADE_INPUT = new JTextField();
		IDADE_INPUT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		IDADE_INPUT.setColumns(10);
		IDADE_INPUT.setBounds(66, 116, 36, 20);
		frame.getContentPane().add(IDADE_INPUT);
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "INSERT into contatos(cpf,nome,idade) VALUES(?,?,?)";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					
					
					comando.setString(1, CPF_INPUT.getText());
					comando.setString(2, NOME_INPUT.getText());
					comando.setInt(3, Integer.parseInt(IDADE_INPUT.getText()));
					
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
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
			}
			}});
		btnInserir.setBounds(13, 171, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JButton btnAlterar = new JButton("ALTERAR");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "UPDATE contatos SET nome=?,idade=? WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					comando.setString(1, NOME_INPUT.getText());
					comando.setInt(2, Integer.parseInt(IDADE_INPUT.getText()));
					comando.setString(3, CPF_INPUT.getText());
					
					
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS ALTERADOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}
			}
		});
		btnAlterar.setBounds(132, 171, 89, 23);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnDeletar = new JButton("EXCLUIR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "DELETE FROM contatos WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					
					comando.setString(1, CPF_INPUT.getText());
					
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS EXCLUÍDOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}
			}
		});
		btnDeletar.setBounds(242, 171, 89, 23);
		frame.getContentPane().add(btnDeletar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 216, 320, 145);
		frame.getContentPane().add(scrollPane);
		
		table_listagem = new JTable();
		scrollPane.setViewportView(table_listagem);
	}
}
