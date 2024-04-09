import java.io.BufferedReader;
import java.io.FileReader;

public class LeituraArquivo {

	public static void main(String[] args) {
		String arquivo = "src/funcionarios.csv";
		String linha = "";
		
		String[] cpf = new String[50];
		String[] nome = new String[50];
		double[] salario = new double[50];
		String[] colunas = new String[3];
		
		BufferedReader leitor;
		
		try {
			leitor = new BufferedReader(new FileReader(arquivo)); // Carregamento do Arquivo
			linha = leitor.readLine();	// Cabeçalho
			colunas = linha.split(";");
			System.out.println("|     " + colunas[0] + "     |      " + colunas[1] + "      |    " + colunas[2] + "    |");
			System.out.println("|-------------|------------|--------------|");
			
			
			linha = leitor.readLine();	// Lê Primeira linha
			
			int x = 0;
		while(linha != null) {	
			colunas = linha.split(";");
			
			cpf[x] = colunas[0];
			nome[x]= colunas[1];
			salario[x] = Double.parseDouble(colunas[2]);
			
			x++;	
			
			linha = leitor.readLine();
		}
						
		for(int i = 0; i<x; i++) {
			System.out.println("| " + cpf[i] + " | " + nome[i] + " | " + salario[i] + " |");
		}
		
		double maior = 0;
		int maiorQuem = 0;
		
		for(int j = 0; j < x; j++) {
			if(maior < salario[j]) {
				maior = salario[j];
				maiorQuem = j;
			}
		}
		
		System.out.println("Quem tem o maior salário é " + nome[maiorQuem] + " com " + maior);
		
		double menor = 99999999;
		int menorQuem = 0;
		
		for(int j = 0; j < x; j++) {
			if(menor > salario[j]) {
				menor = salario[j];
				menorQuem = j;
			}
		}
		
		System.out.println("Quem tem o menor salário é " + nome[menorQuem] + " com " + menor);
		
		
		
		leitor.close();		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
		


