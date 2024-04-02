import javax.swing.JOptionPane;

public class Volumes {
	
	public static double VerificaEntradaDouble (double entrada, String variavel) {
		while (entrada == 0) {
			try {
				entrada = Double.parseDouble(JOptionPane.showInputDialog("Qual a medida "+ variavel + " do cilindro em Centímetros?" ));
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Digite um número Válido!!!");
				entrada = 0;
			}
		}
		
		return entrada;
	}
	
	public static void main(String[] args) {
		// Calcule o volume de um cilindro
		
		double r = 0;
		double h = 0;
		
		r = VerificaEntradaDouble(r, "do raio");
		h = VerificaEntradaDouble(h, "da altura");
		
		double volume = (Math.PI * Math.pow(r, 2)) * h;
		
		JOptionPane.showMessageDialog(null, "O volume desse cilindro será de " + String.format("%.2f", volume));
		
		
	}
}
