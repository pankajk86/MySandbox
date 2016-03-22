package goal.algorithms.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * It creates a graph of Type T.
 * 
 * @author pankajkumar
 *
 * @param <T> Graph of Type T.
 */
public class Graph<T> {

	private Map<Vertex<T>, List<Vertex<T>>> adjMap;
	
	public Graph() {
		this.adjMap = new HashMap<Vertex<T>, List<Vertex<T>>>();
	}

	/**
	 * It adds an edge between {@link Vertex}s v1 and v2.
	 * 
	 * @param v1 First vertex of the edge.
	 * @param v2 Second vertex of the edge.
	 */
	public void addEdge(Vertex<T> v1, Vertex<T> v2) {
		
		boolean startExists = false, endExists = false;
		
		for(Vertex<T> vertex: adjMap.keySet()) {
			if(vertex.getId() == v1.getId()) {
				startExists = true;
			}
			
			if(vertex.getId() == v2.getId()) {
				endExists = true;
			}
		}
		
		if(!startExists) {
			adjMap.put(v1, v1.getAdjVertices());
		}
		
		if(!endExists) {
			adjMap.put(v2, v2.getAdjVertices());
		}
		
		adjMap.get(v1).add(v2);
		adjMap.get(v2).add(v1);
	}
	
	/**
	 * It deletes the edge between the {@link Vertex}s v1 and v2.
	 * If there's no edge between start and end, it will do nothing. 
	 * 
	 * @param v1 first vertex of the edge.
	 * @param v2 second vertex of the edge.
	 */
	public void deleteEdge(Vertex<T> v1, Vertex<T> v2) {
		
		boolean startExists = false, endExists = false;
		Vertex<T> startVertexInAdjMap = null, endVertexInAdjMap = null;
		
		for(Vertex<T> vertex: adjMap.keySet()) {
			if(vertex.getId() == v1.getId()) {
				startExists = true;
				startVertexInAdjMap = vertex;
			}
			
			if(vertex.getId() == v2.getId()) {
				endExists = true;
				endVertexInAdjMap = vertex;
			}
		}
		
		if(!startExists || !endExists) {
			return;
		}
		
		if(startVertexInAdjMap != null && endVertexInAdjMap != null) {
			
			List<Vertex<T>> startAdjVertexList = startVertexInAdjMap.getAdjVertices();
			List<Vertex<T>> endAdjVertexList = endVertexInAdjMap.getAdjVertices();
			
			for(Vertex<T> vertex: startAdjVertexList) {
				if(vertex.getId() == v2.getId()) {
					startAdjVertexList.remove(vertex);
				}
			}
			
			for(Vertex<T> vertex: endAdjVertexList) {
				if(vertex.getId() == v1.getId()) {
					endAdjVertexList.remove(vertex);
				}
			}
		}
	}
	
	/**
	 * @return
	 */
	public Map<Vertex<T>, List<Vertex<T>>> getAdjMap() {
		return this.adjMap;
	}
	
}
