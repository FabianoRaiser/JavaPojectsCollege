import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal {

	private JFrame frame;
	private JTextField PESO_INPUT;
	private JTextField ALTURA_INPUT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 346, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PESO:");
		lblNewLabel.setBounds(28, 43, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ALTURA:");
		lblNewLabel_1.setBounds(28, 86, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		PESO_INPUT = new JTextField();
		PESO_INPUT.setBounds(84, 40, 86, 20);
		frame.getContentPane().add(PESO_INPUT);
		PESO_INPUT.setColumns(10);
		
		ALTURA_INPUT = new JTextField();
		ALTURA_INPUT.setBounds(84, 83, 86, 20);
		frame.getContentPane().add(ALTURA_INPUT);
		ALTURA_INPUT.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular IMC");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botao CALCULAR_IMC
				
				double pesoValue = Double.parseDouble(PESO_INPUT.getText());
				double alturaValue = Double.parseDouble(ALTURA_INPUT.getText());
				
				double resultado = pesoValue / Math.pow(alturaValue, 2);
				
				JOptionPane.showMessageDialog(null, String.format("O Seu IMC é de %.2f", resultado));
				
				PESO_INPUT.setText(null);
				ALTURA_INPUT.setText(null);
				
			}
		});
		btnCalcular.setBounds(65, 133, 105, 23);
		frame.getContentPane().add(btnCalcular);
		
		JLabel Jlabel_imagem = new JLabel("");
		
		Jlabel_imagem.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1668541.png")).getImage().getScaledInstance(135, 100, Image.SCALE_SMOOTH)));
		
		Jlabel_imagem.setBounds(188, 40, 132, 116);
		frame.getContentPane().add(Jlabel_imagem);
	}

	/* ARRUMAR!!!!
	private String SistuaçãoIMC(double imc) {
		String mensagem = switch (imc) {
		case  imc < 18.5 -> "abaixo do peso";
		case imc >= 18.5 && imc <= 24.9 -> "com o peso normal";
		case imc >= 25 && imc <= 29.9 -> "com sobrepeso";
		case imc >= 30 && imc <= 34.9 -> "com obesidade";
		case imc >= 35 && imc <= 39.9 -> "com obesidade morbida";
		case imc >= 40 -> "com obesidade morbida grave!";
		default -> "invalido!";
		};
		
	return mensagem;
	}
	*/

}
