package goal.clrs.chap2;

public class InsertionSort {

	public static void main(String[] args) {
		int arr[] = {5, 2, 4, 6, 1, 3};
		
		for(int i=1; i<arr.length; i++){
			int current = arr[i];
			int k=i-1;
			
			while(arr[k] > current && k >= 0){
				arr[k+1] = arr[k];
				k--;
				if(k<0) 
					break;
			}
			
			arr[k+1] = current;
		}
		
		print(arr);
	}

	
	private static void print(int[] arr) {
		for(int j=0; j<arr.length; j++){
			System.out.print(arr[j] + " "); 
		}
		System.out.println();
	}
}
