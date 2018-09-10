package graphs;

public class TestDisjointSet {

	public static void main(String[] args) {
		DisjointSet dset = new DisjointSet();
		
		dset.makeSet(1);
		dset.makeSet(2);
		dset.makeSet(3);
		dset.makeSet(4);
		dset.makeSet(5);
		dset.makeSet(6);
		dset.makeSet(7);
		
		dset.union(1, 2);
		dset.union(2, 3);
		dset.union(4, 5);
		dset.union(6, 7);
		dset.union(5, 6);
		dset.union(3, 7);

		for(int i = 0; i < dset.size(); i++) {
			System.out.println(dset.find(i + 1));
		}
	}

}
