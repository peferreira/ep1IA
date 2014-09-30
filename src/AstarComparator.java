import java.util.Comparator;

public class AstarComparator implements Comparator<EstadoDoPuzzle>{

	@Override
	public int compare(EstadoDoPuzzle o1, EstadoDoPuzzle o2) {
		return o1.heuristicaUm() - o2.heuristicaUm();
	}

}
