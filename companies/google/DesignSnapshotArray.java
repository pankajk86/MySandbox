package google;

import java.util.TreeMap;

public class DesignSnapshotArray {

	public static void main(String[] args) {
		SnapshotArray ssa = new SnapshotArray(3);
		ssa.set(0, 5);
		ssa.snap();
		ssa.set(0, 6);
		System.out.println(ssa.get(0, 0));
	}

}

class SnapshotArray {

	private int snapId = 0;
	private TreeMap<Integer, Integer>[] map;
	
    @SuppressWarnings("unchecked")
	public SnapshotArray(int length) {
    	map = new TreeMap[length];
        for(int i = 0; i < length; i++) {
        	map[i] = new TreeMap<>();
        	map[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        map[index].put(snapId, val);
    }
    
    public int snap() {
		return snapId++;
        
    }
    
    public int get(int index, int snapId) {
		return map[index].floorEntry(snapId).getValue();
        
    }
}


