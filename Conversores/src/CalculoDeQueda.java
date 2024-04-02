import javax.swing.JOptionPane;

public class CalculoDeQueda {

	public static double VerificaEntradaDouble (double entrada, String variavel) {
		while (entrada == 0) {
			try {
				entrada = Double.parseDouble(JOptionPane.showInputDialog("Qual a valor "+ variavel + "?" ));
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "Digite um número Válido!!!");
				entrada = 0;
			}
		}
		
		return entrada;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double Y, t, V;
		Y = 0;
		t = 0;
		V = 0;
		
		double g = 9.8;
		
		t = VerificaEntradaDouble(t, "do tempo total do movimento");
		V = VerificaEntradaDouble(V, "da velocidade inicial do movimento");
		
		t = t/2;
		Y = (V)*((g*Math.pow(t, 2))/2);
		
		JOptionPane.showMessageDialog(null, "A altura que o objeto alcança no /n topo to movimento será " + Y + "m");
		
	}

}
