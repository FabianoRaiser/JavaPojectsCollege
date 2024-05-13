package mqtt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Chat {

	private JFrame frame;
	private JTextField APELIDO_INPUT;
	private JTextField TEXTO_INPUT;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
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
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblApelido = new JLabel("APELIDO:");
		lblApelido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApelido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApelido.setBounds(23, 40, 75, 23);
		frame.getContentPane().add(lblApelido);
		
		JLabel lblMensagem = new JLabel("MENSAGEM:");
		lblMensagem.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMensagem.setBounds(23, 75, 75, 14);
		frame.getContentPane().add(lblMensagem);
		
		APELIDO_INPUT = new JTextField();
		APELIDO_INPUT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		APELIDO_INPUT.setBounds(108, 43, 105, 20);
		frame.getContentPane().add(APELIDO_INPUT);
		APELIDO_INPUT.setColumns(10);
		
		TEXTO_INPUT = new JTextField();
		TEXTO_INPUT.setBounds(108, 74, 277, 20);
		frame.getContentPane().add(TEXTO_INPUT);
		TEXTO_INPUT.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Botão ENVIAR MENSAGEM:
				Mensagem UOL = new Mensagem();
				String txt = APELIDO_INPUT.getText() + ": " + TEXTO_INPUT.getText();
				UOL.Enviar("unisociesc/batepapo/pirigo", txt);
				
				TEXTO_INPUT.setText(null);
			}
		});
		btnEnviar.setBounds(296, 105, 89, 23);
		frame.getContentPane().add(btnEnviar);
		
		JTextArea area = new JTextArea();
		area.setBounds(23, 139, 385, 208);
		frame.getContentPane().add(area);
	}
}
