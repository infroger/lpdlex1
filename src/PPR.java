import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PPR extends Parser {
	
	
	public PPR (String nomeArquivo ) throws IOException {
		super(nomeArquivo);
		
		//Pág. 74 da apostila
		analisaPrograma();
	}
	
	
	//Pág. 74 da apostila
	public boolean analisaPrograma() throws IOException {
		buscaToken();
		if (t.tipo == Tipo.SPROGRAMA) {
			System.out.print(t.tipo +" ");
			buscaToken();
			if (t.tipo == Tipo.SIDENTIFICADOR) {
				System.out.print(t.tipo +": " +t.conteudo +' ');
				//Adiciona identificador à tabela de símbolos
				ts.ts.put(t.conteudo, t);
				buscaToken();
				if (t.tipo == Tipo.SPONTO_E_VIRGULA) {
					System.out.print(t.tipo +" ");
					if (analisaBloco()) {
						buscaToken();
						if (t.tipo == Tipo.SPONTO)
							System.out.print(t.tipo +" ");
							return true;
					} else {
						System.out.println("Bloco principal não encontrado: " +t.linha +", " +t.coluna);
						return false;
					}
				} else {
					System.out.println("Ponto e vírgula esperado: " +t.linha +", " +t.coluna);
					return false;					
				}
			} else {
				System.out.println("Identificador esperado: " +t.linha +", " +t.coluna);
				return false;
			}
		} else {
			System.out.println("Programa principal não encontrado: " +t.linha +", " +t.coluna);
			return false;
		}
		//System.out.println("Erro genérico: " +t.linha +", " +t.coluna);
		//return false;
	}
	
	public boolean analisaBloco() throws IOException {
		
		buscaToken();
		
		if (analisaEtapaDeclaracaoDeVariaveis()) {
			
		} else {
			System.out.println("Erro na declaração de variáveis: " +t.linha +", " +t.coluna);
			return false;			
		}
		
		
		return true;
	}
	
	public boolean analisaEtapaDeclaracaoDeVariaveis() {
		return true;
	}

}
