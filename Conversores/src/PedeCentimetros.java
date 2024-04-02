import javax.swing.JOptionPane;

public class PedeCentimetros {

	public static double Converte( double entrada, String medida) {
		double saida;
		if (medida == "milimetros") {
			saida = entrada * 10;
		}else if (medida == "metros") {
			saida = entrada / 100;
		} else {
			saida = 0;
		}
		return saida;
	}
	
	public static double VerificaEntradaDouble (double entrada) {
		while (entrada == 0) {
			try {
				entrada = Double.parseDouble(JOptionPane.showInputDialog("Qual a medida em Centímetros?" ));
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Digite um número Válido!!!");
				entrada = 0;
			}
		}
		
		return entrada;
	}
	
	public static void main(String[] args) {
		/* Faça um programa que peça um número em centímetros 
		e converta para metros e milímetros. 
		Mostre para o usuário os resultados. */
		
		double centimetros = 0;
		
		centimetros = VerificaEntradaDouble(centimetros);
		
		JOptionPane.showMessageDialog(null, "As conversões são: \n" + 
				"Em metros: " + Converte(centimetros, "metros") + "m \n" +
				"Em milimetros: " + Converte(centimetros, "milimetros") + "mm");
	}

}
