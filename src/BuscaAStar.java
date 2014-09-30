import java.util.Hashtable;
import java.util.PriorityQueue;


public class BuscaAStar extends BuscaCustoUniforme {
	public BuscaAStar() {
		htable = new Hashtable<String, EstadoDoPuzzle>();
		AstarComparator asc = new AstarComparator();
		queue = new PriorityQueue<EstadoDoPuzzle>(100, asc);
	}
	
	void imprime(EstadoDoPuzzle epz) {
		System.out.println("A*");
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

