package google;

import java.util.Stack;

public class LongestAbsoluteFilePath {

	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"; //"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		//input = "a.txt";
		int maxLength = lengthLongestPath(input);
		System.out.println(maxLength);
	}

	private static int lengthLongestPath(String input) {
		
		if(input.isEmpty() || input == null) {
			return 0;
		}
		
		if(!input.contains(".")) {
			return 0;
		}

		String[] parts = input.split("\n");
		int deepestIndex = 0, depth = 0;
		
		for(int i = 1; i < parts.length; i++) {
			int currentDepth = parts[i].split("\t").length; 
			if(currentDepth > depth) {
				deepestIndex = i;
				depth = currentDepth - 1; 
			}
		}
		
		Stack<String> stack = new Stack<>();
		stack.push(parts[deepestIndex]);
		
		for(int i = deepestIndex - 1; i >= 0; i--) {
			if(i == 0) {
				stack.push(parts[i]);
			} else {
				int currentLength = parts[i].split("\t").length;
				int deepest = stack.peek().split("\t").length;
				
				if(currentLength == deepest - 1) {
					stack.push(parts[i]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop().trim()).append("/");
		}
		
		String path = sb.substring(0, sb.length() - 1); 
		return path.length();
	}

}
