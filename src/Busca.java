import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class Busca {
	int N = 2;
	int numNoVisitados;
	
	Busca() {
		
		numNoVisitados = 0;
	}

	int getNoVisitados(){
		return numNoVisitados;
	}
	EstadoDoPuzzle busca() {
				return null;
	}
	void init(String s,int n){
	}
	void imprime(EstadoDoPuzzle epz){};
	/* verifica se o estado do puzzle é uma solução */
	/*boolean ehSolucao(char[] s) {
		int primeiroa, ultimob;
		ultimob = 0;
		primeiroa = s.length - 1;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == 'B') {
				ultimob = i;
			} else if (s[i] == 'A' && i < primeiroa) {
				primeiroa = i;
			}
		}
		if (primeiroa > ultimob)
			return true;
		return false;
	}*/
}
