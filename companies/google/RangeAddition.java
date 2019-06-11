package google;

public class RangeAddition {

	public static void main(String[] args) {
		int length = 5;
		int[][] updates = { { 1, 3, 2 }, { 2, 4, 3 }, { 0, 2, -2 } };
		int[] result = getModifiedArray(length, updates);
		
		for(int i: result)
			System.out.print(i + " ");
	}

	// TIME LIMIT EXCEEDED
	private static int[] getModifiedArray(int length, int[][] updates) {
		int[][] values = new int[updates.length][length];
		int[] result = new int[length];
		
		for(int i = 0; i < updates.length; i++) {
			for(int j = updates[i][0]; j <= updates[i][1]; j++)
				values[i][j] = updates[i][2];
		}
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < updates.length; j++)
				result[i] += values[j][i];
		}
		
		return result;
	}

}
