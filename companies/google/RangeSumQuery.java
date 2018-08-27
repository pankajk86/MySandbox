package google;

public class RangeSumQuery {

	public static void main(String[] args) {
		int[] a = {1, 3, 5};
		
		NumArray obj = new NumArray(a);
		System.out.println(obj.sumRange(0, 2));
		obj.update(1, 2);
		System.out.println(obj.sumRange(0, 2));
	}

}


class NumArray {
	
	int[] a;
	int[] aggr;
	
	public NumArray(int[] nums) {
		this.a = nums;
		this.aggr = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			if(i == 0) this.aggr[0] = nums[0];
			else this.aggr[i] = this.aggr[i - 1] + nums[i];
		}
	}
	
	public void update(int i, int val) {
		int current = a[i];
		int change = val - current;
		a[i] = val;
		
		for(int j = i; j < aggr.length; j++) {
			aggr[j] += change;
		}
	}
	
	public int sumRange(int i, int j) {
		
		int right = aggr[j];
		int left = i == 0 ? 0 : aggr[i - 1];
		
		return (right - left);
	}
}