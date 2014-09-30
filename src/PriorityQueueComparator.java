import java.util.Comparator;
public class PriorityQueueComparator implements Comparator<EstadoDoPuzzle>{

	@Override
	public int compare(EstadoDoPuzzle o1, EstadoDoPuzzle o2) {
		return o1.custo - o2.custo;
	}



}
