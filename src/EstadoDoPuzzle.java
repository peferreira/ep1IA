import java.util.LinkedList;
import java.util.Queue;

import java.util.Hashtable;

public class EstadoDoPuzzle {

	char puzzle[];
	int profundidade;
	int posicaoVazia;
	int tamanhoPuzzle;
	EstadoDoPuzzle pai;
	LinkedList<EstadoDoPuzzle> queue;
	Hashtable<String, EstadoDoPuzzle> htable;

	public EstadoDoPuzzle(int profundidade, int pvazia,
			LinkedList<EstadoDoPuzzle> queue, int N, char puzzle[],
			Hashtable<String, EstadoDoPuzzle> htable, EstadoDoPuzzle pai) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.queue = queue;
		this.tamanhoPuzzle = N;
		this.htable = htable;
		this.pai = pai;
	}

	public EstadoDoPuzzle(int profundidade, int pvazia,
			LinkedList<EstadoDoPuzzle> queue, int N, char puzzle[],
			EstadoDoPuzzle pai) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.queue = queue;
		this.tamanhoPuzzle = N;
		this.htable = null;
		this.pai = pai;
	}

	public EstadoDoPuzzle(int profundidade, int pvazia,
			LinkedList<EstadoDoPuzzle> queue, int N, char puzzle[],
			Hashtable<String, EstadoDoPuzzle> htable) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.queue = queue;
		this.tamanhoPuzzle = N;
		this.htable = htable;
		this.pai = this;
	}

	public EstadoDoPuzzle(int profundidade, int pvazia,
			LinkedList<EstadoDoPuzzle> queue, int N, char puzzle[]) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.queue = queue;
		this.tamanhoPuzzle = N;
		this.pai = this;
	}
	
	public EstadoDoPuzzle(int profundidade, int pvazia,
			 int N, char puzzle[], EstadoDoPuzzle pai) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.tamanhoPuzzle = N;
		this.pai = pai;
	}
	
	public EstadoDoPuzzle(int profundidade, int pvazia,
			 int N, char puzzle[]) {
		this.puzzle = puzzle;
		this.profundidade = profundidade;
		this.posicaoVazia = pvazia;
		this.tamanhoPuzzle = N;
		this.pai = this;
	}



	EstadoDoPuzzle geraEstadosAdjacentes() {
		char temp;
		char newpuzzle[];

		int i = posicaoVazia;
		int j = posicaoVazia;
		EstadoDoPuzzle ep;
		while (((i > 0 && abs(posicaoVazia, i)))) {
			i--;
			newpuzzle = new char[tamanhoPuzzle];
			for (int k = 0; k < tamanhoPuzzle; k++) {
				newpuzzle[k] = puzzle[k];
			}
			temp = newpuzzle[i];
			newpuzzle[i] = newpuzzle[posicaoVazia];
			newpuzzle[posicaoVazia] = temp;
			if (!htable.containsKey(new String(newpuzzle))) {
				ep = new EstadoDoPuzzle(profundidade + 1, i, queue,
						tamanhoPuzzle, newpuzzle, htable, this);

				htable.put(new String(newpuzzle), ep);
				if (ehSolucao(newpuzzle)) {
					return ep;
				}
				queue.add(ep);
			}

		}
		while (j < tamanhoPuzzle - 1 && abs(posicaoVazia, j)) {
			j++;
			newpuzzle = new char[tamanhoPuzzle];
			for (int k = 0; k < tamanhoPuzzle; k++) {
				newpuzzle[k] = puzzle[k];
			}
			temp = newpuzzle[j];
			newpuzzle[j] = newpuzzle[posicaoVazia];
			newpuzzle[posicaoVazia] = temp;
			if (!htable.containsKey(new String(newpuzzle))) {
				ep = new EstadoDoPuzzle(profundidade + 1, j, queue,
						tamanhoPuzzle, newpuzzle, htable, this);

				htable.put(new String(newpuzzle), ep);
				if (ehSolucao(newpuzzle)) {
					return ep;
				}
				queue.add(ep);
			}
		}
		return null;

	}

	/* verifica se o estado do puzzle é uma solução */
	boolean ehSolucao(char[] s) {
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
	}

	boolean abs(int a, int b) {
		if (Math.abs(a - b) < tamanhoPuzzle / 2)
			return true;
		return false;
	}

	char[] getPuzzle() {
		return puzzle;
	}

	void imprimeFamilia(EstadoDoPuzzle no) {
		if (no == no.pai) {
			System.out.println(no.puzzle);
			return;
		} else {
			imprimeFamilia(no.pai);
			System.out.println(no.puzzle);
		}
	}
}
