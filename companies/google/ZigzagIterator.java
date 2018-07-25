package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigzagIterator {
	
	private int[] indices;
	private int nextIndex = 0;
	private List<List<Integer>> lists = new ArrayList<>();

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		this.indices = new int[2];
		this.lists.addAll(Arrays.asList(v1, v2));
    }
	
	public ZigzagIterator(List<List<Integer>> list) {
		this.indices = new int[list.size()];
		this.lists = list;
	}

    public int next() {

    	if(nextIndex == this.lists.size())
    		nextIndex = 0;
    	
    	int nextToProcess = indices[nextIndex];
    	int result = -1;
    	if(nextToProcess < this.lists.get(nextIndex).size()) {
    		result = this.lists.get(nextIndex).get(nextToProcess);
    		this.indices[nextIndex] += 1;
    		nextIndex++;
    	} else {
    		if(hasNext()) {
    			nextIndex++;
    			result = next();
    		}
    	}
    	
    	return result;
    }

    public boolean hasNext() {
    	int i = 0;
    	boolean result = false;
    	for(List<Integer> list: lists) {
    		if(indices[i++] < list.size()) {
    			result = result || true;
    		}
    	}
        return result;
    }
	
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<>();
		List<Integer> v2 = new ArrayList<>();
		List<Integer> v3 = new ArrayList<>();
		v1.addAll(Arrays.asList(1, 2, 3));
		v2.addAll(Arrays.asList(4, 5, 6, 7));
		v3.addAll(Arrays.asList(8, 9));
		
		ZigzagIterator zi = new ZigzagIterator(v1, v2);
		
		zi = new ZigzagIterator(Arrays.asList(v1, v2, v3));
		
		while(zi.hasNext()) {
			System.out.print(zi.next() + ", ");
		}
	}

}
