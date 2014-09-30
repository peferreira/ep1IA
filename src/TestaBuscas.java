import static org.junit.Assert.assertTrue;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;


public class TestaBuscas {

	@Before
	public void setUp() throws Exception {
	}
	
	
	
	/*@Test
	public void testaBuscaEmLargura() {
		Hashtable<String, EstadoDoPuzzle> htable =	;

		Busca b = new BuscaEmLargura(htable);
		LinkedList<EstadoDoPuzzle> queue = new LinkedList<EstadoDoPuzzle>();
		char puzzle[] = {'B','A','-','A','B'};
		EstadoDoPuzzle no = new EstadoDoPuzzle(0, 2, queue, 5, puzzle,htable);
		no = b.busca(no);
		if(no != null){
			
			System.out.println("profundidade:"+ no.profundidade);
			System.out.println("nos explorados:" + b.getNoVisitados());
			System.out.println("nos gerados: "+ (queue.size()+b.getNoVisitados()));
			no.imprimeFamilia(no);

		}
		
		
	}*/
	/*@Test
	public void testaBuscaProfundidadeLimitada(){
		BuscaProfundidadeLimitada b = new BuscaProfundidadeLimitada();
		EstadoDoPuzzle a = b.BPL(3);
		if(a == null){
			System.out.println("não foi possivel encontrar solucao nesse limite");
		}
		
		
	}
	*/
	/*
	@Test
	public void testaBuscaProfundidadeIterativa(){
		BuscaProfundidadeIterativa b = new BuscaProfundidadeIterativa();
		EstadoDoPuzzle a = b.BPI();
		System.out.println("profundidade: " + a.profundidade);		
		
	}
	*/
	
	@Test
	public void testaFuncaoHeuristica(){
		
		int profundidade = 3;
		int pvazia = 2;
		int N = 5;
		char puzzle[] = {'A','A','-','B','B'};
		int custo = 0;
		EstadoDoPuzzle a = new EstadoDoPuzzle(profundidade, pvazia, N, puzzle, custo);
		System.out.println(a.heuristicaUm());
	}
	
	/*@Test
	public void testaBuscaEmProfundidade() {
		Hashtable<String, EstadoDoPuzzle> htable = new Hashtable<String, EstadoDoPuzzle>();

		Busca b = new BuscaEmProfundidade(htable);
		LinkedList<EstadoDoPuzzle> queue = new LinkedList<EstadoDoPuzzle>();
		char puzzle[] = {'B','A','-','A','B'};
		EstadoDoPuzzle no = new EstadoDoPuzzle(0, 2, queue, 5, puzzle,htable);
		no = b.busca(no);
		if(no != null){
			System.out.println("profundidade:"+ no.profundidade);
			System.out.println("nos explorados:" + b.getNoVisitados());
			System.out.println("nos gerados: "+ (queue.size()+b.getNoVisitados()));
			no.imprimeFamilia(no);
		}
		
		
	}*/
	
	/*@Test
	public void verificaGeradorDeEstadosAdjacentes(){
		int tamanhoPuzzle = 5; 
		char puzzle[] = {'B','A',' ','A','B'};

		Queue<EstadoDoPuzzle> q = new LinkedList<EstadoDoPuzzle>();
		EstadoDoPuzzle ep = new EstadoDoPuzzle(0, 2, q, tamanhoPuzzle, puzzle);
		ep.geraEstadosAdjacentes();
		ep = q.poll();
		while(ep != null){
			System.out.println(ep.getPuzzle());
			ep = q.poll();
		}
	
	}
*/
}
