
public class Token {
	Tipo t; //tipo
	String c; //conteúdo
	int l; //linha inicial
	int col; //coluna inicial
	
	public Token(Tipo t, String c, int l, int col) {
		this.t = t;
		this.c = c;
		this.l = l;
		this.col = col;
	}
	
	public String toString() {
		return t +": " +c +"=> linha: " +l +", col: " +col;
	}
}
