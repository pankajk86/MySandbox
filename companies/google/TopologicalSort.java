package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopologicalSort {

	public static void main(String[] args) {
		List<TSNode> graph = createGraph();
		List<Character> result = topologicalSort(graph);
		System.out.println(result);
	}

	private static List<Character> topologicalSort(List<TSNode> graph) {
		Set<Character> visited = new HashSet<>();
		List<Character> result = new ArrayList<>();
		
		for(TSNode node: graph) {
			if(!visited.contains(node.label)) {
				dfs(visited, node, result);
				if(result.size() == graph.size())
					break;
			}
		}
		return result;
	}

	private static void dfs(Set<Character> visited, TSNode curr, List<Character> result) {
		for(TSNode neighbor: curr.neighbors) {
			if(!visited.contains(neighbor.label)) {
				dfs(visited, neighbor, result);
			}
		}
		visited.add(curr.label); result.add(curr.label);
	}

	private static List<TSNode> createGraph() {
		TSNode a = new TSNode('A');
		TSNode b = new TSNode('B');
		TSNode c = new TSNode('C');
		TSNode d = new TSNode('D');
		TSNode e = new TSNode('E');
		TSNode f = new TSNode('F');
		TSNode g = new TSNode('G');
		
		f.neighbors.add(g);
		e.neighbors.add(f); d.neighbors.add(f);
		c.neighbors.add(e);
		b.neighbors.addAll(Arrays.asList(c, d));
		a.neighbors.add(c);
		
		List<TSNode> graph = Arrays.asList(a, b, c, d, e, f, g);
		return graph;
	}

}

class TSNode {
	char label;
	List<TSNode> neighbors;
	
	TSNode(char label) {
		this.label = label;
		this.neighbors = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return String.valueOf(label);
	}
}