package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedList {

	public static void main(String[] args) {
		List<NestedInteger> nlist = createdNestedList();
		NestedIterator nit = new NestedIterator(nlist);
		while(nit.hasNext()) {
			System.out.println(nit.next());
		}

		System.out.println("==========");

		// cached
		NestedIteratorII nitII = new NestedIteratorII(nlist);
		while(nitII.hasNext()) {
			System.out.println(nitII.next());
		}

	}

	private static List<NestedInteger> createdNestedList() {

		NestedInteger n1 = new NestedInteger(4, null);
		NestedInteger n2 = new NestedInteger(5, null);
		NestedInteger n3 = new NestedInteger(6, null);
		
		NestedInteger n4 = new NestedInteger(null, Arrays.asList(n1, n2, n3));
		NestedInteger n5 = new NestedInteger(3, null);
		NestedInteger n6 = new NestedInteger(2, null);
		NestedInteger n7 = new NestedInteger(null, Arrays.asList(n6, n5, n4));
		
		NestedInteger n8 = new NestedInteger(1, null);
		
		return Arrays.asList(n8, n7);
	}

}

class NestedIteratorII implements Iterator<Integer> {

	private List<Integer> list;
	private int index = 0;

	public NestedIteratorII(List<NestedInteger> nestedList) {
		list = new ArrayList<>();
		flatten(nestedList);

	}

	private void flatten(List<NestedInteger> nl) {
		for (NestedInteger ni : nl) {
			if (ni.isInteger()) list.add(ni.getInteger());
			else flatten(ni.getList());
		}
	}

	@Override
	public Integer next() {
		return list.get(index++);
	}

	@Override
	public boolean hasNext() {
		return index < list.size();
	}
}

class NestedIterator implements Iterator<Integer> {
	
	private List<NestedInteger> nlist = null;
	private int index;
	
	public NestedIterator(List<NestedInteger> nestedList) {
		this.nlist = nestedList;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {

		if(index < nlist.size()) {
			if(nlist.get(index) == null) return false;
			if(!nlist.get(index).isInteger()) {
				nlist = nlist.get(index).getList();
				index = 0;
			}
			return true;
		}
		return false;
	}

	@Override
	public Integer next() {
		if(!nlist.isEmpty() && nlist.get(index).isInteger()) {
			Integer result = nlist.get(index).getInteger();
			index++;
			return result;
		}
		
		return null;
	}
	
}


class NestedInteger {
	
	Integer i;
	List<NestedInteger> list;
	
	public NestedInteger(Integer i, List<NestedInteger> list) {
		this.i = i;
		this.list = list;
	}
	
	public boolean isInteger() {
		return (i != null && list == null);
	}
	
	public Integer getInteger() {
		return this.i;
	}
	
	public List<NestedInteger> getList() {
		return this.list;
	}
}
