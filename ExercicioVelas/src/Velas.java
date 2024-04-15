import java.io.BufferedReader;
import java.io.FileReader;

public class Velas {

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
			
			
			// Exercício 1: quantas velas verdes (nr_verdes) e quantas velas vermelhas existem?			
			int nr_verdes = 0;
			int nr_vermelhas = 0;
			int nr_daido = 0;

			for(int p=0;p<500;p++)
			{

				if (fechamento[p]>abertura[p]) {
					nr_verdes++;
				} else if (fechamento[p]<abertura[p]) { 
					nr_vermelhas++; 
				} else {
					nr_daido++;
				}
			}

			// Exercício 2: quantas tendências de reversão de baixa para alta existem?
			int nrRevBaiAlt = 0;
			int nrRevAltBai = 0;
			int nrVerdeBaiAlt = 0;
			int nrVermelhaBaiAlt = 0;
			int nrVerdeAltBai = 0;
			int nrVermelhaAltBai = 0;
			
			for(int p = 1; p<499;p++) {
				// System.out.println(p);
				if(minimo[p-1]<minimo[p] && minimo[p]>minimo[p+1]) {
					nrRevBaiAlt++;
					// Exercício 4: quantas velas verdes aparecem após uma reversão de baixa para alta?
					if(fechamento[p+2] > abertura[p+2]) {
						nrVerdeBaiAlt++;
					}
					
					// Exercício 5: quantas velas vermelhas aparecem após uma reversão de baixa para alta?
					if(fechamento[p+2] < abertura[p+2]) {
						nrVermelhaBaiAlt++;
					}
				} 
				// Exercício 3: quantas tendências de reversão de alta para baixa existem?
				if(maximo[p-1]>maximo[p] && maximo[p]<maximo[p+1]) {
					nrRevAltBai++;
					// Exercício 6: quantas velas verdes aparecem após uma reversão de alta para baixa?
					if(fechamento[p+2] > abertura[p+2]) {
						nrVerdeAltBai++;
					}
					// Exercício 7: quantas velas vermelhas aparecem após uma reversão de alta para baixa?
					if(fechamento[p+2] < abertura[p+2]) {
						nrVermelhaAltBai++;
					}
				}
			}
				

				
				




				// Exercício 8: qual a amplitude "máximo-mínimo" média a cada 3 velas?
				// Exercício 9: qual a média de fechamento a cada 3 velas?
				// Exercício 10: após a média de fechamento de 3 velas, analise a quarta vela e conte quantas
				              // possuem fechamento maior que a média e quantas possuem fechamento menor que a média.
			
			// Mostre os resultados dos exercícios anteriores aqui fora da estrutura de repetição.
			// Por exemplo, para o exercício 1 ficará assim:
			// System.out.println("EXISTEM " + nr_verdes + " VELAS VERDES");
			
			System.out.println("VERDES: " + nr_verdes); // Exercicio 1a
			System.out.println("VERMELHAS: " + nr_vermelhas); // exercicio 1b
			System.out.println("DAIDO: " + nr_daido); // exercicio 1c -> extra
			 
			System.out.println("REVERSÕES BAIXA ALTA: " + nrRevBaiAlt);
			System.out.println("REVERSÕES ALTA BAIXA: " + nrRevAltBai);
			
			System.out.println("VELAS VERDES APÓS UMA REVERSÃO BAIXA ALTA: " + nrVerdeBaiAlt);
			System.out.println("VELAS VERDES APÓS UMA REVERSÃO ALTA BAIXA: " + nrVermelhaBaiAlt);
			
			System.out.println("VELAS VERMELHAS APÓS UMA REVERSÃO BAIXA ALTA: " + nrVerdeAltBai);
			System.out.println("VELAS VERMELHAS APÓS UMA REVERSÃO ALTA BAIXA: " + nrVermelhaAltBai);
			
			
		}
		catch(Exception erro)
		{
			System.out.println("Erro ao tentar ler arquivo");
		}
	}

}
