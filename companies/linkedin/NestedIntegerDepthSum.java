package linkedin;

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerDepthSum {

	public static void main(String[] args) {
		List<NestedInteger> nestedList = createNestedList();
		int result = depthSum(nestedList);
		System.out.println(result);
	}

	private static int depthSum(List<NestedInteger> nestedList) {
		int depth = 0, result = 0;
        List<Element> list = flattenList(nestedList, depth);
        
        for(Element e: list) 
            result += (e.value * e.depth);
        
        return result;
	}
	
	private static List<Element> flattenList(List<NestedInteger> nestedList, int depth) {
        List<Element> result = new ArrayList<>();
        for(NestedInteger ni: nestedList) {
            if(ni.isInteger()) {
                result.add(new Element(ni.getInteger(), depth + 1));
            } else {
                List<Element> el = flattenList(ni.getList(), depth + 1);
                result.addAll(el);
            }
        }
        return result;
    }

	private static List<NestedInteger> createNestedList() {
		//TODO
		return null;
	}

}

class Element {
    int value; int depth;
    
    public Element(int value, int depth) {
        this.value = value; this.depth = depth;
    }
}

class NestedIntegerImpl implements NestedInteger {
	
	NestedInteger ni = null;
	
	// Constructor initializes an empty nested list.
    public NestedIntegerImpl() {
    	
    }

    // Constructor initializes a single integer.
    public NestedIntegerImpl(int value) {
    	
    }

	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInteger(int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(NestedInteger ni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

