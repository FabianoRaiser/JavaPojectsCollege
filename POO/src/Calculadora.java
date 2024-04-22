
public class Calculadora {
	double memoria;
	double v1;
	double v2;
	
	public double Somar(double n1, double n2) {
		return (n1 + n2);
	}
	
	public double Subtrair(double n1, double n2) {
		return (n1 - n2);
	}
	
	public double Multiplicar(double n1, double n2) {
		return (n1 * n2);
	}
	
	public double Dividir(double n1, double n2) {
		return (n1 / n2);
	}
	
	public void Guardar( double n) {
		this.memoria = n;
		
	}
	
	public double Recuperar() {
		return this.memoria;
	}
}
