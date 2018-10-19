package arrays;

import java.util.Random;

public class ShuffleAnArray {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		Shuffle s = new Shuffle(a);
		
		int[] t = s.shuffle();
		for(int i: t) System.out.print(i + " ");
		System.out.println();
		
		t = s.shuffle();
		for(int i: t) System.out.print(i + " ");
		System.out.println();
		
		t = s.reset();
		for(int i: t) System.out.print(i + " ");
		System.out.println();
		
		t = s.shuffle();
		for(int i: t) System.out.print(i + " ");
		System.out.println();
	}

}

class Shuffle {
	
	private int[] original = null;
	private Random rand = null;
	
	public Shuffle(int[] nums) {
		original = nums;
		rand = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
    public int[] reset() {
		return original;
        
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] cache = original.clone();
    	for(int j = 1; j < cache.length; j++) {
    		int i = rand.nextInt(j + 1);
    		swap(cache, i, j);
    	}
		return cache;
    }
    
    private void swap(int[] a, int i, int j) {
    	int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
