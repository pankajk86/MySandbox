package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.addAll(Arrays.asList("Hell##o World!", "What a l0vely day$$@^||", ""));
		
		String encoded = encode(strings);
		System.out.println("----" + encoded + "-----");
		List<String> decoded = decode(encoded);
		System.out.println(decoded);
	}
	
	private static String encode(List<String> strings) {
		StringBuilder sb = new StringBuilder();
		
		for(String s: strings) {
			sb.append(s.replace("|", "||")).append(" | ");
		}
		return sb.toString();
	}

	private static List<String> decode(String encoded) {
		List<String> result = new ArrayList<>();
		String[] sarr = encoded.split(" \\| ", -1);
		
		for(int i = 0; i < sarr.length - 1; i++) {
			result.add(sarr[i].replace("||", "|"));
		}
		return result;
	}
}
