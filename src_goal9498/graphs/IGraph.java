package graphs;

import java.util.List;

public interface IGraph {

	public void addUndirectedEdges(List<int[]> edges);
	public int size();
	public void print();
}
