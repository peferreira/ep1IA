public class BuscaProfundidadeIterativa extends BuscaProfundidadeLimitada {

	public BuscaProfundidadeIterativa() {

	}

	public EstadoDoPuzzle busca() {
		return BPI();
	}

	EstadoDoPuzzle BPI() {
		EstadoDoPuzzle resultado = null;
		int limite = 1;
		while (resultado == null) {
			resultado = BPL(limite);
			limite++;
		}
		return resultado;
	}

	void imprime(EstadoDoPuzzle epz) {
		System.out.println("BPI");
		System.out.println("caminho da solução:");
		epz.imprimeFamilia(epz);
		System.out.println("numero de nós explorados:" + numNoVisitados);
		System.out.println("numero de nós gerados:" + (numNoVisitados));
		System.out.println("profundidade da meta:" + epz.profundidade);
		System.out.println("custo da solução:" + epz.custo);
		System.out.println("fator de ramificação médio: " + (numNoVisitados)
				/ numNoVisitados);
	}
}
