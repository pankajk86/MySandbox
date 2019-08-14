package linkedin;

public class PartitionToKEqualSumSubsets {

	public static void main(String[] args) {
		int[] a = { 2, 2, 2, 2, 3, 4, 5 };
		int k = 4;
		
		boolean result = canPartition(a, k);
		System.out.println(result);
	}

	private static boolean canPartition(int[] a, int k) {
		if(a == null || a.length == 0) return false;
		int sum = 0;
		for(int i: a) sum += i;
		if(k < 0 || sum % k != 0) return false;
		
		boolean[] visited = new boolean[a.length];
		return canPartition(a, k, visited, 0, 0, 0, sum / k);
	}

	private static boolean canPartition(int[] a, int k, boolean[] visited, int start, int sum, int count, int target) {
		if(k == 1) return true;
		if(sum == target && count > 0)
			return canPartition(a, k - 1, visited, 0, 0, 0, target);
		
		for(int i = start; i < a.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(canPartition(a, k, visited, i + 1, sum + a[i], count++, target))
					return true;
				visited[i] = false;
			}
		}
		return false;
	}

}
