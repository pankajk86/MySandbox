package goal.algorithms.strings;

public class RemainderOfString {

	public static void main(String[] args) {
		String s = "abcde", sub = "cd";
		int i = s.indexOf(sub);
		if(i >= 0) {
			int ind = i + sub.length();
			String result = s.substring(ind);
			System.out.println(result);
		} else {
			System.out.println("not found");
		}
	}

}
