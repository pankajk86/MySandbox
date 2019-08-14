package linkedin;

import java.util.List;

public class NestedIntegerWeightSum {

	public static void main(String[] args) {
		List<NestedInteger> nestedList = createNestedList();
		int result = depthSum(nestedList);
		System.out.println(result);
	}

	private static int depthSum(List<NestedInteger> nestedList) {
		return flatten(nestedList, 1);
	}
	
	private static int flatten(List<NestedInteger> nl, int depth) {
        int result = 0;
        
        for(NestedInteger ni: nl) {
            if(ni.isInteger()) result += ni.getInteger() * depth;
            else result += flatten(ni.getList(), depth + 1);
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

