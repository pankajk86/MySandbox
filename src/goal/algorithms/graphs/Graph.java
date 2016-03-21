package goal.algorithms.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

	private Map<Vertex<T>, List<Edge<T>>> adjMap;
	private List<Vertex<T>> verticesList;
	
	public Graph() {
		this.adjMap = new HashMap<Vertex<T>, List<Edge<T>>>();
	}

	/**
	 * @param start
	 * @param end
	 */
	public void addEdge(Vertex<T> start, Vertex<T> end) {
		
		boolean startExists = false, endExists = false;
		
		for(Vertex<T> vertex: adjMap.keySet()) {
			if(vertex.getId() == start.getId()) {
				startExists = true;
			}
			
			if(vertex.getId() == end.getId()) {
				endExists = true;
			}
		}
		
		if(!startExists) {
			adjMap.put(start, start.getAdjEdges());
		}
		
		if(!endExists) {
			adjMap.put(end, end.getAdjEdges());
		}
		
		Edge<T> newEdge = new Edge<T>(start, end);
		adjMap.get(start).add(newEdge);
		adjMap.get(end).add(newEdge);
	}
	
	/**
	 * @param start
	 * @param end
	 */
	public void deleteEdge(Vertex<T> start, Vertex<T> end) {
		
	}
	
	/**
	 * @return
	 */
	public Map<Vertex<T>, List<Edge<T>>> getAdjMap() {
		return this.adjMap;
	}
	
	/**
	 * @return
	 */
	public List<Vertex<T>> getVerticesList() {
		return this.verticesList;
	}
}
