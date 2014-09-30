import java.util.Hashtable;
import java.util.LinkedList;


public class BuscaEmProfundidade extends Busca{
	Hashtable<String, EstadoDoPuzzle> htable; 
	LinkedList<EstadoDoPuzzle> queue;
	private EstadoDoPuzzle noIni;

	public BuscaEmProfundidade() {
		htable = new Hashtable<String, EstadoDoPuzzle>();
		queue = new LinkedList<EstadoDoPuzzle>();
	}

	EstadoDoPuzzle busca() {
		EstadoDoPuzzle noInicial = noIni;
		EstadoDoPuzzle solucao = null;
		if (noInicial.ehSolucao(noInicial.getPuzzle())) {
			return noInicial;
		}
		numNoVisitados++;
		htable.put(new String(noInicial.getPuzzle()), noInicial);
		noInicial.geraEstadosAdjacentes();
		while (!noInicial.queue.isEmpty()) {
			noInicial = noInicial.queue.pollLast();
			numNoVisitados++;
			solucao = noInicial.geraEstadosAdjacentes();
			if(solucao != null)
				return solucao;
		}
		return null;

	}
	
	void init(String a, int N) {
		int tamanhoPuzzle = 2*N + 1;
		char p[] = new char[tamanhoPuzzle];
		int pvazia = -1;
		for (int i = 0; i < tamanhoPuzzle; i++) {
			p[i] = a.charAt(i);
			if(p[i] == '-')
				pvazia = i;
		}
		
		if(pvazia < 0){
			System.out.println("não existe posição vazia no vetor fornecido");
		}
		noIni = new EstadoDoPuzzle(0, pvazia, queue,  tamanhoPuzzle,p, htable,0);
		noIni.puzzle = p;
		noIni.posicaoVazia = pvazia;
	}
	
	void imprime(EstadoDoPuzzle epz){
		System.out.println("BP");
		System.out.println("caminho da solução:");
		epz.imprimeFamilia(epz);
		System.out.println("numero de nós explorados:" + numNoVisitados);
		System.out.println("numero de nós gerados:" + (numNoVisitados + queue.size()));
		System.out.println("profundidade da meta:" + epz.profundidade);
		System.out.println("custo da solução:" +epz.custo);
		System.out.println("fator de ramificação médio: " + (float)(numNoVisitados + queue.size())/(float)numNoVisitados);
	}
}
