public class BuscaProfundidadeLimitada extends Busca {

	int limite;
	private EstadoDoPuzzle noIni;

	public BuscaProfundidadeLimitada(int limite) {
		this.limite = limite;
	}
	public BuscaProfundidadeLimitada() {
		this.limite = 3;
	}
	public EstadoDoPuzzle busca(){
		return BPL(limite);
	}
	public EstadoDoPuzzle BPL(int limite) {
		this.limite = limite;
		EstadoDoPuzzle noInicial = noIni;
		noInicial = BPLRecursiva(noInicial, limite);
		return noInicial;
	}

	EstadoDoPuzzle BPLRecursiva(EstadoDoPuzzle no, int limi) {
		if (no.ehSolucao(no.puzzle)) {
			return no;
		} else if (limi == 0)
			return null;
		else {
			int i = no.posicaoVazia;
			int j = no.posicaoVazia;
			EstadoDoPuzzle filho, resultado;
			resultado = null;
			char temp;
			char newpuzzle[];
			int newCusto;
			while (((i > 0 && no.abs(no.posicaoVazia, i)))) {
				i--;
				newpuzzle = new char[no.tamanhoPuzzle];
				for (int k = 0; k < no.tamanhoPuzzle; k++) {
					newpuzzle[k] = no.puzzle[k];
				}
				temp = newpuzzle[i];
				newpuzzle[i] = newpuzzle[no.posicaoVazia];
				newpuzzle[no.posicaoVazia] = temp;
				newCusto = no.custo + Math.abs(no.posicaoVazia-i);

				filho = new EstadoDoPuzzle((no.profundidade) + 1, i,
						no.tamanhoPuzzle, newpuzzle, no,newCusto);
				resultado = BPLRecursiva(filho, limi - 1);
				numNoVisitados++;
				if (resultado != null)
					return resultado;
			}
			if (resultado == null) {
				while (j < no.tamanhoPuzzle - 1 && no.abs(no.posicaoVazia, j)) {
					j++;
					newpuzzle = new char[no.tamanhoPuzzle];
					for (int k = 0; k < no.tamanhoPuzzle; k++) {
						newpuzzle[k] = no.puzzle[k];
					}
					temp = newpuzzle[j];
					newpuzzle[j] = newpuzzle[no.posicaoVazia];
					newpuzzle[no.posicaoVazia] = temp;
					newCusto = no.custo + Math.abs(no.posicaoVazia-j);

					filho = new EstadoDoPuzzle((no.profundidade) + 1, j,
							no.tamanhoPuzzle, newpuzzle, no,newCusto);
					resultado = BPLRecursiva(filho, limi - 1);
					numNoVisitados++;
					if (resultado != null)
						return resultado;
				}
			}
			return resultado;
		}
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
		noIni = new EstadoDoPuzzle(0, pvazia, tamanhoPuzzle, p,0);
		noIni.puzzle = p;
		noIni.posicaoVazia = pvazia;
	}

	void imprime(EstadoDoPuzzle epz) {
		System.out.println("BPL");
		System.out.println("caminho da solução:");
		epz.imprimeFamilia(epz);
		System.out.println("numero de nós explorados:" + numNoVisitados);
		System.out.println("numero de nós gerados:"
				+ (numNoVisitados));
		System.out.println("profundidade da meta:" + epz.profundidade);
		System.out.println("custo da solução:" + epz.custo);
		System.out.println("fator de ramificação médio: "
				+ (numNoVisitados) / numNoVisitados);
	}
}
