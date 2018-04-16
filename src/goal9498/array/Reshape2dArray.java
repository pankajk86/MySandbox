package goal9498.array;

public class Reshape2dArray {

	public static void main(String[] args) {
		int[][] a = new int[][] {
			{1,2,3}, 
			{4,5,6},
			{7,8,9},
			{10,11,12}
		};
		Reshape2dArray t = new Reshape2dArray();
		int r = 6, c = 2;
		int[][] result = t.matrixReshape(a, r, c);
		
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++) {
				System.out.print(result[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int cols = nums[0].length;
        
        if(rows * cols != r * c) {
            return nums;
        }
        
        int count = 0, p = 0, q = 0;
        int[][] result = new int[r][c];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(count < c) {
                    result[p][q] = nums[i][j];
                    count++;
                } else {
                    p++; q = 0;
                    result[p][q] = nums[i][j];
                    count = 1;
                }
                q++;
            }
        }
        return result;
    }

}
