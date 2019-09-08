import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Lexer l = new Lexer();
		Lexer l = new Lexer(args[0]);
		//ArrayList<Token> tokens = l.lex(args[0]);
		ArrayList<Token> tokens = l.lex();
		System.out.println("Tokens: " +tokens.size());
		
		tokens.forEach (token -> {System.out.println(token.toString());} );
	}

}
