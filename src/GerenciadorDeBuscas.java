import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GerenciadorDeBuscas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int N = 0;
		String s = null;
		String nomeBusca;
		File file = new File(System.getProperty("user.dir") + "/src/puz1.txt");
		try {
			Scanner sc = new Scanner(file);
			N = sc.nextInt();
			s = sc.next();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		GerenciadorDeBuscas gbusca = new GerenciadorDeBuscas();
		nomeBusca = "BCU";

		if (nomeBusca.equals("BL")) {
			gbusca.buscaBL(s, N);
		} else if (nomeBusca.equals("BP")) {
			gbusca.buscaBP(s, N);
		} else if (nomeBusca.equals("BPL")) {
			gbusca.buscaBPL(s, N);
		} else if (nomeBusca.equals("BPI")) {
			gbusca.buscaBPI(s, N);
		} else if (nomeBusca.equals("BCU")) {
			gbusca.buscaBCU(s, N);
		}

	}

	private void buscaBCU(String s, int N) {
		Busca b = null;
		EstadoDoPuzzle e;
		b = new BuscaCustoUniforme();
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		}
	}

	void buscaBL(String s, int N) {
		Busca b = null;
		EstadoDoPuzzle e;
		b = new BuscaEmLargura();
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		}
	}

	void buscaBP(String s, int N) {
		Busca b = null;
		EstadoDoPuzzle e;
		b = new BuscaEmProfundidade();
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		}
	}

	void buscaBPL(String s, int N) {
		Busca b = null;
		EstadoDoPuzzle e;
		b = new BuscaProfundidadeLimitada(10);
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		} else {
			System.out
					.println("limite não é suficiente para encontrar solução");
		}

	}

	void buscaBPI(String s, int N) {
		Busca b = null;
		EstadoDoPuzzle e;
		b = new BuscaProfundidadeIterativa();
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		}
	}

}
