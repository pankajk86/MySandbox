package google;

public class ShortestWayToFormString {

	public static void main(String[] args) {
		String source = "xyz", target = "xzyxz";
		int result = shortestWay(source, target);
		System.out.println(result);
	}

	private static int shortestWay(String source, String target) {
		int result = 0;
		
		for(int t = 0; t < target.length();) {
			int temp = t;
			for(int s = 0; s < source.length(); s++) {
				if(t < target.length() && source.charAt(s) == target.charAt(t))
					t++;
			}
			if(t == temp) return -1;
			result++;
		}
		
		return result;
	}

}
