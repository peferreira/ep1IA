import java.util.Hashtable;
import java.util.PriorityQueue;

public class BuscaCustoUniforme extends Busca {

	Hashtable<String, EstadoDoPuzzle> htable;
	EstadoDoPuzzle noIni;
	PriorityQueue<EstadoDoPuzzle> queue;

	public BuscaCustoUniforme() {
		htable = new Hashtable<String, EstadoDoPuzzle>();
		PriorityQueueComparator pqc = new PriorityQueueComparator();
		queue = new PriorityQueue<EstadoDoPuzzle>(100, pqc);

	}

	EstadoDoPuzzle busca() {
		EstadoDoPuzzle noInicial = noIni;
		EstadoDoPuzzle solucao = null;
		if (noInicial.ehSolucao(noInicial.getPuzzle())) {
			return noInicial;
		}
		htable.put(new String(noInicial.getPuzzle()), noInicial);
		geraAdjacentes(noInicial);
		numNoVisitados++;
		while (!queue.isEmpty()) {
			noInicial = queue.poll();
			solucao = geraAdjacentes(noInicial);
			numNoVisitados++;
			if (solucao != null)
				return solucao;
		}
		return null;

	}

	EstadoDoPuzzle geraAdjacentes(EstadoDoPuzzle oldEp) {
		char temp;
		char newpuzzle[];
		int newCusto = 0;
		int i = oldEp.posicaoVazia;
		int j = oldEp.posicaoVazia;
		EstadoDoPuzzle ep;
		while (((i > 0 && oldEp.abs(oldEp.posicaoVazia, i)))) {

			i--;
			newpuzzle = new char[oldEp.tamanhoPuzzle];
			for (int k = 0; k < oldEp.tamanhoPuzzle; k++) {
				newpuzzle[k] = oldEp.puzzle[k];
			}
			temp = newpuzzle[i];
			newpuzzle[i] = newpuzzle[oldEp.posicaoVazia];
			newpuzzle[oldEp.posicaoVazia] = temp;
			if (htable.containsKey(new String(newpuzzle))) {
				newCusto = oldEp.custo + Math.abs(oldEp.posicaoVazia - i);
				if (htable.get(new String(newpuzzle)).custo > newCusto) {
					ep = new EstadoDoPuzzle(oldEp.profundidade + 1, i,
							oldEp.tamanhoPuzzle, newpuzzle, oldEp, newCusto);
					htable.put(new String(newpuzzle), ep);
					if (oldEp.ehSolucao(newpuzzle)) {
						return ep;
					}
					queue.add(ep);
				}
			} else {
				newCusto = oldEp.custo + Math.abs(oldEp.posicaoVazia - i);
				ep = new EstadoDoPuzzle(oldEp.profundidade + 1, i,
						oldEp.tamanhoPuzzle, newpuzzle, oldEp, newCusto);
				htable.put(new String(newpuzzle), ep);
				if (oldEp.ehSolucao(newpuzzle)) {
					return ep;
				}
				queue.add(ep);
			}
		}

		while (j < oldEp.tamanhoPuzzle - 1 && oldEp.abs(oldEp.posicaoVazia, j)) {

			j++;
			newpuzzle = new char[oldEp.tamanhoPuzzle];
			for (int k = 0; k < oldEp.tamanhoPuzzle; k++) {
				newpuzzle[k] = oldEp.puzzle[k];
			}
			temp = newpuzzle[j];
			newpuzzle[j] = newpuzzle[oldEp.posicaoVazia];
			newpuzzle[oldEp.posicaoVazia] = temp;

			if (htable.containsKey(new String(newpuzzle))) {
				newCusto = oldEp.custo + Math.abs(oldEp.posicaoVazia - j);
				if (htable.get(new String(newpuzzle)).custo > newCusto) {
					ep = new EstadoDoPuzzle(oldEp.profundidade + 1, j,
							oldEp.tamanhoPuzzle, newpuzzle, oldEp, newCusto);
					htable.put(new String(newpuzzle), ep);
					if (oldEp.ehSolucao(newpuzzle)) {
						return ep;
					}
					queue.add(ep);
				}
			} else {
				newCusto = oldEp.custo + Math.abs(oldEp.posicaoVazia - j);
				ep = new EstadoDoPuzzle(oldEp.profundidade + 1, j,
						oldEp.tamanhoPuzzle, newpuzzle, oldEp, newCusto);
				htable.put(new String(newpuzzle), ep);
				if (oldEp.ehSolucao(newpuzzle)) {
					return ep;
				}
				queue.add(ep);
			}
		}
		return null;
	}

	void init(String a, int N) {
		int tamanhoPuzzle = 2 * N + 1;
		char p[] = new char[tamanhoPuzzle];
		int pvazia = -1;
		for (int i = 0; i < tamanhoPuzzle; i++) {
			p[i] = a.charAt(i);
			if (p[i] == '-')
				pvazia = i;
		}

		if (pvazia < 0) {
			System.out.println("não existe posição vazia no vetor fornecido");
		}
		noIni = new EstadoDoPuzzle(0, pvazia, tamanhoPuzzle, p, 0);
		noIni.puzzle = p;
		noIni.posicaoVazia = pvazia;
	}

	void imprime(EstadoDoPuzzle epz) {
		System.out.println("BCU");
		System.out.println("caminho da solução:");
		epz.imprimeFamilia(epz);
		System.out.println("numero de nós explorados:" + numNoVisitados);
		System.out.println("numero de nós gerados:"
				+ (numNoVisitados + queue.size()));
		System.out.println("profundidade da meta:" + epz.profundidade);
		System.out.println("custo da solução:" + epz.custo);
		System.out.println("fator de ramificação médio: "
				+ (float)(numNoVisitados + queue.size()) / (float)numNoVisitados);
	}
}
