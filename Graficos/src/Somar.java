import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Somar {

	private JFrame frame;
	private JTextField n1;
	private JTextField n2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Somar window = new Somar();
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
	public Somar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 213, 235);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NÚMERO 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 38, 85, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNmero = new JLabel("NÚMERO 2:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNmero.setBounds(10, 87, 85, 32);
		frame.getContentPane().add(lblNmero);
		
		n1 = new JTextField();
		n1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		n1.setBounds(105, 42, 86, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		n2.setColumns(10);
		n2.setBounds(105, 93, 86, 20);
		frame.getContentPane().add(n2);
		
		JButton btnSomar = new JButton("SOMAR");
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//botão somar
				double resultado = 0;
				double n1Value = Double.parseDouble(n1.getText());
				double n2Value = Double.parseDouble(n2.getText());
				
				resultado = n1Value + n2Value;
				
				JOptionPane.showMessageDialog(null, resultado);
				
				n1.setText(null);
				n2.setText(null);
			}
		});
		btnSomar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSomar.setBounds(57, 159, 89, 23);
		frame.getContentPane().add(btnSomar);
	}
}
