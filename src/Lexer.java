import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Lexer {
	
	Reader r; //Arquivo a ser parseado
	int intch; //código do caracter sendo analisado
	char ch; //caracter sendo analisado
	ArrayList<Token> ltoken = new ArrayList<Token>(); //Lista de tokens
	
	
	public Token buscaToken(char ch) throws IOException {
		
		String lexema = "";
		
		switch (ch) {
			case ':': return new Token(Tipo.SATRIBUICAO, ":"); 
			case '+': return new Token(Tipo.SMAIS, "+"); 
			case '-': return new Token(Tipo.SMENOS, "-"); 
			case '*': return new Token(Tipo.SMULTIPLICACAO, "*"); 
			case ';': return new Token(Tipo.SPONTO_E_VIRGULA, ";");
			case '.': return new Token(Tipo.SPONTO, "."); 
			default: 
				if (Character.isDigit(ch))	 {
					lexema += ch;
					while ((intch = r.read()) != - 1  && Character.isDigit((char) intch))
						ch = (char) intch;
						lexema += ch;
						return new Token(Tipo.SNUMERO, lexema); 
				}
				else if (Character.isLetter(ch)) {
					lexema += ch;
					while ((intch = r.read()) != - 1  && (Character.isLetter(ch) || Character.isDigit((char) intch))) {
						ch = (char) intch;
						lexema += ch;						
						//System.out.println(lexema);
					}
					switch (lexema) {
						case "programa": return new Token(Tipo.SPROGRAMA, lexema); 
						case "inteiro" : return new Token(Tipo.SINTEIRO, lexema); 
						default: 		 return new Token(Tipo.SIDENTIFICADOR, lexema); 
					}
				}					
				else { //Erro
					System.out.println();
					return new Token(Tipo.SERRO, Character.toString(ch));
				}
		}

		
		
	}

	public ArrayList<Token> lex(String f) throws IOException {

	  //Pág. 62 da apostila
	  //https://www.javamex.com/tutorials/io/character_stream_reader.shtml
				
	  r = new BufferedReader(new InputStreamReader(
		          new FileInputStream(f), "US-ASCII"));
	  try {
	    int count = 0;
	    while ((intch = r.read()) != -1) {
	      ch = (char) intch;
	      /*
	      if (Character.isLetter(ch)) {
	        count++;
	      }*/
	      
	      //Pula comentários
	      if (ch == '{')
	        while (ch != '}' && intch != -1) {
	    	    intch = r.read();
	    	    ch = (char) intch;
	        }
	    	 
	      //Pula espaços em branco, tabs e nova linha
	      if (ch == ' ')
	        while ((ch == ' ' || ch == '\n' || ch == '\t') && intch != -1){
	    	    intch = r.read();
	    	    ch = (char) intch;
	        }

	      ltoken.add( buscaToken(ch) );
	      
	    }
	    System.out.println(count);
	  } finally {
		System.out.println("Encerrando.");
	    r.close();
	  }
	return ltoken;				
	}
	
}
