package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfIslandsII {

	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}, {0, 2}};
		
		List<Integer> result = numOfIslands(m, n, positions);
		System.out.println(result);
	}

	private static List<Integer> numOfIslands(int m, int n, int[][] positions) {
		
		List<Integer> result = new ArrayList<>();
		UF uf = new UF();
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		
		for(int[] position: positions) {
			Cell cell = new Cell(position[0], position[1]);
			uf.makeSet(cell);
			
			for(int[] dir: dirs) {
				Cell next = new Cell(position[0] + dir[0], position[1] + dir[1]);
				if(uf.contains(next))
					uf.union(cell, next);
			}
			result.add(uf.size());
		}
		return result;
	}
}

class UF {
	Map<Cell, Node> map = new HashMap<>();
	
	public void makeSet(Cell cell) {
		Node node = new Node(0, cell);
		map.put(cell, node);
	}
	
	public Node find(Node node) {
		if(node.parent == node) return node;
		node.parent = find(node.parent);
		return node.parent;
	}
	
	public void union(Cell a, Cell b) {
		Node n1 = map.get(a), n2 = map.get(b);
		Node p1 = find(n1), p2 = find(n2);
		
		if(p1.cell == p2.cell) return;
		
		if(p1.rank >= p2.rank) {
			p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p1.rank;
			p2.parent = p1;
		} else p1.parent = p2;
	}
	
	public boolean contains(Cell cell) {
		return map.containsKey(cell);
	}
	
	public int size() {
		Set<Cell> parents = new HashSet<>();
		for(Map.Entry<Cell, Node> entry: map.entrySet()) {
			parents.add(entry.getValue().parent.cell);
		}
		return parents.size();
	}
}

class Node {
	int rank;
	Node parent;
	Cell cell;
	
	Node(int rank, Cell cell) {
		this.rank = rank;
		this.parent = this;
		this.cell = cell;
	}
}

class Cell {
	int x, y;
	
	Cell(int x, int y) {
		this.x = x; this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime1 = 31, prime2 = 47;
		int result = 1;
		result = (prime1 * result + x) + (prime2 * result + y);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cell other = (Cell) obj;
        if (x != other.x || y != other.y)
            return false;
        return true;
	}
}
