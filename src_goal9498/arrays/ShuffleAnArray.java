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
	
	private int[] original, nums;
	private Random rand;
	
	public Shuffle(int[] nums) {
		this.original = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
			this.original[i] = nums[i];
		
		this.nums = nums;
		rand = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	this.nums = original;
    	this.original = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
			this.original[i] = nums[i];
		
		return this.nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {

    	for(int j = 1; j < nums.length; j++) {
    		int i = rand.nextInt(j + 1);
    		swap(nums, i, j);
    	}
		return nums;
    }
    
    private void swap(int[] a, int i, int j) {
    	int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
}
