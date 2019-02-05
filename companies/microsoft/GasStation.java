package microsoft;

public class GasStation {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		
		int result = canCompleteCircuit(gas, cost);
		System.out.println(result);
	}

	private static int canCompleteCircuit(int[] gas, int[] cost) {
		int start = gas.length - 1, end = 0;
		int sum = gas[start] - cost[start];
		
		while(start > end) {
			if(sum >= 0) {
				sum += gas[end] - cost[end];
				end++;
			} else {
				start--;
				sum += gas[start] - cost[start];
			}
		}
		return sum >= 0 ? start : -1;
	}

}
