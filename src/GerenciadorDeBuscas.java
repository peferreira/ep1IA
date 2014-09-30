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
		nomeBusca = "BPL";

		if (nomeBusca.equals("BL")) {
			gbusca.buscaBL(s, N);
		} else if (nomeBusca.equals("BP")) {
			gbusca.buscaBP(s, N);
		} else if (nomeBusca.equals("BPL")) {
			gbusca.buscaBPL(s, N);
		} else if (nomeBusca.equals("BPI")) {
			gbusca.buscaBPI(s, N);
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
		b = new BuscaProfundidadeLimitada();
		b.init(s, N);
		e = b.busca();
		if (e != null) {
			b.imprime(e);
		}

	}

	void buscaBPI(String s, int N) {
		System.out.println("fazer busca BPI");
	}

}
