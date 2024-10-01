package uber;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		int maxWidth = 10;
		
		List<String> result = fullyJustify(words, maxWidth);
		System.out.println(result);
	}

	private static List<String> fullyJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<>();
        List<Integer> space = new ArrayList<>();
		StringBuilder line = new StringBuilder();
		for(int i=0; i<words.length; i++){
			if(line.isEmpty() || line.length()+words[i].length()<maxWidth){
                createLine(line, words[i], space);
                if(line.length()==maxWidth){
					result.add(line.toString());
					line=new StringBuilder();
					space=new ArrayList<>();
				}
				else{
					if(i==words.length-1){
						result.add(leftJust(line, maxWidth).toString());
					}
				}
			}
			else{
				line = addSpace(line,maxWidth,space);
				result.add(line.toString());
				space=new ArrayList<>();
				line = createLine(new StringBuilder(), words[i], space);
				if(i==words.length-1)
					result.add(leftJust(line, maxWidth).toString());
			}
		}
		return result;
	}

	public static StringBuilder createLine(StringBuilder line, String words, List<Integer> space){
		if(line.isEmpty()){
			line.append(words);
		}
		else{
			line.append(" ");
			space.add(line.length()-1);
			line.append(words);
		}
		return line;
	}
	public static StringBuilder leftJust(StringBuilder line, int width){
		while(line.length()<width){
			line.append(" ");
		}
		return line;
	}
	public static StringBuilder addSpace(StringBuilder line, int width, List<Integer> space){
		if(space.isEmpty()){
			return leftJust(line,width);
		}
		int prev = 0;
		int j=0;
		while(line.length()<width){
			if(j==0) line.insert(space.get(j++), " ");
			else line.insert(space.get(j++)+prev, " ");
			if(j==space.size()) j = 0;
			prev++;
		}
		return line;
	}
}
