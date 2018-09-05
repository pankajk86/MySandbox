package google;

public class MirrorReflection {

	public static void main(String[] args) {
		int p = 5, q = 3;
		int result = findMirror(p, q);
		System.out.println(result);
	}

	private static int findMirror(int p, int q) {

		int i = 1;
		
		while((i * q) % p != 0) 
			i++;
		
		if(i % 2 == 0)
			return 2;
		else {
			if((i * q / p) % 2 == 0)
				return 0;
			else
				return 1;
		}
	}

}
