
public class Principal {

	public static void main(String[] args) {
		
		CalculadoraAvancada EPSON = new CalculadoraAvancada(); // Cria o objeto EPSON
		
		double resposta = EPSON.Somar(5, 7); // Realiza a operação de somar
		
		
		System.out.println(resposta); // Imprime a resposta
		
		EPSON.Guardar(resposta); // guarda a resposta no atributo memoria
		
		resposta = EPSON.Subtrair(8, 3); // realiza a operação de subtrair
		
		System.out.println(resposta); // Imprime a resposta
		
		System.out.println(EPSON.Multiplicar(resposta, EPSON.Recuperar())); // realiza a multiplicação com o valor da resposta e o valor guardado no atributo memoria

		EPSON.AreaRetangulo(10, 2);
		
		resposta = EPSON.VolumeCubo(7);
		
		System.out.println("VOLUME DO CUBO = " + resposta);
		
		resposta = EPSON.AreaTriangulo(5, 9);
		System.out.println("ÁREA DO TRIÂNGULO = " + resposta);
		
		resposta = EPSON.AreaCirculo(10);
		System.out.println("ÁREA DO CICULO = " + resposta);
		
		EPSON.AreaRetangulo(10, 10);
		resposta = EPSON.VolumePiramide(15);
		
		System.out.println("VOLUME DA PIRAMIDE = " + resposta);
		
		resposta = EPSON.VolumeEsfera(10);
		
		System.out.println("VOLUME DA ESFERA = " + resposta);
		
		resposta = EPSON.Subtrair(EPSON.VolumeEsfera(50), EPSON.VolumeEsfera(10));
		
		System.out.println("VOLUME SUBTRAIDO = " + resposta);
		
	}

}
