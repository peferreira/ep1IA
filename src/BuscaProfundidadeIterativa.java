
public class BuscaProfundidadeIterativa extends BuscaProfundidadeLimitada {
	EstadoDoPuzzle BPI(){
		EstadoDoPuzzle resultado = null;
		int limite = 1;
		while(resultado == null){
			resultado = BPL(limite);
			
			System.out.println("limite:" +limite);
			
			limite++;
		}
		return resultado;
	}
}
