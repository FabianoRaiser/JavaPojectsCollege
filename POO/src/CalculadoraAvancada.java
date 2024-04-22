
public class CalculadoraAvancada extends Calculadora{
	
	double area, volume, altura, raio;
	
	public double AreaRetangulo(double base, double altura) {
		
		this.area = this.Multiplicar(base, altura);
		
		return this.area;
	}
	
	public double VolumeCubo(double profundidade) {
		
		return this.Multiplicar(this.area, profundidade);
	}
	
	public double AreaTriangulo(double base, double altura) {
		
		this.area = this.Dividir(this.Multiplicar(base, altura),2);
		
		return this.area;
	}
	
	public double AreaCirculo(double raio) {
		
		this.area = this.Multiplicar(Math.PI, Math.pow(raio, 2));
		
		return this.area;
	}
	
	public double VolumePiramide(double altura) {
		return this.Dividir(this.Multiplicar(this.area,	altura), 3);
	}
	
	public double VolumeEsfera(double raio) {
		return this.Multiplicar(this.Dividir(4, 3),	this.Multiplicar(this.AreaCirculo(raio), raio));
	}
}
