package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeNaryTree {

	public static void main(String[] args) {
		Node root = createNaryTree();
		NaryTree tree = new NaryTree();
		
		String serialized = tree.serialize(root);
		System.out.println(serialized);
		
		Node deserialized = tree.deserialize(serialized);
		System.out.println(serialized.equals(tree.serialize(deserialized)));
	}

	private static Node createNaryTree() {
		Node n5 = new Node(5, new ArrayList<>());
		Node n6 = new Node(6, new ArrayList<>());
		Node n3 = new Node(3, Arrays.asList(n5, n6));
		Node n2 = new Node(2, new ArrayList<>());
		Node n4 = new Node(4, new ArrayList<>());
		Node n1 = new Node(1, Arrays.asList(n3, n2, n4));
		return n1;
	}

}

class NaryTree {
	
	// Encodes a tree to a single string.
    public String serialize(Node root) {
    	if(root == null) return null;
    	List<String> list = new ArrayList<>();
    	serialize(root, list);
        return String.join(",", list);
    }

    private void serialize(Node root, List<String> list) {
    	if(root == null) return;
    	list.add(String.valueOf(root.val));
    	list.add(String.valueOf(root.children.size()));
    	for(Node child: root.children) serialize(child, list);
	}

	// Decodes your encoded data to tree.
    public Node deserialize(String data) {
    	if(data == null || data.isEmpty()) return null;
    	Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

	private Node deserialize(Queue<String> q) {
		int val = Integer.parseInt(q.poll());
		int count = Integer.parseInt(q.poll());
		Node root = new Node(val, new ArrayList<>());
		for(int i = 0; i < count; i++) root.children.add(deserialize(q));
		return root;
	}
}

class Node {
	int val;
    List<Node> children;
    
    public Node(int val, List<Node> children) {
    	this.val = val; this.children = children;
    }
}