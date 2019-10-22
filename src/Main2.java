import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * Usa Lexer2, a implementação com Autômatos Finitos
		 * Ainda usa uma simples lista como Tabela de Símbolos
		 */
		
		//Lexer1 l = new Lexer1();
		Lexer2 l = new Lexer2(args[0]);
		//ArrayList<Token> tokens = l.lex(args[0]);
		ArrayList<Token> tokens = l.lex();
		System.out.println("Tokens: " +tokens.size());
		
		tokens.forEach (token -> {System.out.println(token.toString());} );
	}

}
