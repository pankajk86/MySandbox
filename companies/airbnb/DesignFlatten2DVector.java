package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DesignFlatten2DVector {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>(Arrays.asList(
                Arrays.asList(1,2), Arrays.asList(3), Arrays.asList(4)
             ));
             
		Vector2DI flatten = new Vector2DI(list);
		while(flatten.hasNext())
			System.out.println(flatten.next());
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("a").append("b");
		sb.deleteCharAt(sb.length() - 1);
		
		System.out.println(sb.toString());
	}

}


class Vector2DI implements Iterator<Integer> {
	private List<Integer> flatten = new ArrayList<>();
    private Iterator<Integer> it;
    
    public Vector2DI(List<List<Integer>> list) {
        for(List<Integer> l: list) flatten.addAll(l);
        it = flatten.iterator();
    }
    
    @Override
    public Integer next() {
        if(hasNext()) {
            return it.next();
        }
        return null;
    }
    
    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}