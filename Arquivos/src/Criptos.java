import java.io.BufferedReader;
import java.io.FileReader;

public class Criptos {
	public static void main(String[] args) {
String arquivo = "src/velas.csv";
		
		String[] vetor = new String[500];
		double[] abertura = new double[500];
		double[] fechamento = new double[500];
		double[] maximo = new double[500];
		double[] minimo = new double[500];
		int x = 0;
		
		try {
			BufferedReader leitor = new  BufferedReader(new FileReader(arquivo));
			
			String linha = leitor.readLine(); // Lê a primeira linha que é o cabeçalho e ignora.
			linha = leitor.readLine();  // Lê a próxima linha.
			
			while(linha!=null)
			{
				vetor = linha.split(";");                      // abertura ; fechamento ; maximo ; minimo
				abertura[x]   = Double.parseDouble(vetor[0]);
				fechamento[x] = Double.parseDouble(vetor[1]);
				maximo[x]     = Double.parseDouble(vetor[2]);
				minimo[x]     = Double.parseDouble(vetor[3]);
				
				linha = leitor.readLine();  //  Pula para a próxima linha
				x = x + 1;
			}

			for(x=0;x<500;x++)
			{
				// Exercício 1: quantas velas verdes (nr_verdes) e quantas velas vermelhas existem?
				// Exercício 2: quantas tendências de reversão de baixa para alta existem?
				// Exercício 3: quantas tendências de reversão de alta para baixa existem?
				// Exercício 4: quantas velas verdes aparecem após uma reversão de baixa para alta?
				// Exercício 5: quantas velas vermelhas aparecem após uma reversão de baixa para alta?
				// Exercício 6: quantas velas verdes aparecem após uma reversão de alta para baixa?
				// Exercício 7: quantas velas vermelhas aparecem após uma reversão de alta para baixa?
				// Exercício 8: qual a amplitude "máximo-mínimo" média a cada 3 velas?
				// Exercício 9: qual a média de fechamento a cada 3 velas?
				// Exercício 10: após a média de fechamento de 3 velas, analise a quarta vela e conte quantas
				              // possuem fechamento maior que a média e quantas possuem fechamento menor que a média.
			}
			
			// Mostre os resultados dos exercícios anteriores aqui fora da estrutura de repetição.
			// Por exemplo, para o exercício 1 ficará assim:
			// System.out.println("EXISTEM " + nr_verdes + " VELAS VERDES"); 
			
			
			leitor.close();
			
		}
		catch(Exception erro)
		{
			System.out.println("Erro ao tentar ler arquivo");
		}
	}
}
