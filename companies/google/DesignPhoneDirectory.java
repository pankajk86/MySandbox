package google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DesignPhoneDirectory {

	public static void main(String[] args) {
		PhoneDirectory dir = new PhoneDirectory(3);
		
		System.out.println(dir.get());
		System.out.println(dir.get());
		System.out.println(dir.check(2));
		System.out.println(dir.get());
		System.out.println(dir.check(2));
		dir.release(2);
		System.out.println(dir.check(2));
	}

}

class PhoneDirectory {
	
	private Set<Integer> assignedSet = null;
	private Queue<Integer> availableList = null;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        this.assignedSet = new HashSet<>();
        this.availableList = new LinkedList<>();
        
        for(int i = 0; i < maxNumbers; i++) {
        	availableList.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(availableList.size() == 0) return -1;
        int curr = availableList.poll();
        assignedSet.add(curr);
        return curr;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !assignedSet.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if(assignedSet.contains(number)) {
    		assignedSet.remove(number);
    		availableList.add(number);
    	}
    }
}
