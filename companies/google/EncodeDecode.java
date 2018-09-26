package google;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		//strings.addAll(Arrays.asList("Hell##o World!", "What a l0vely day$$@^||"));
//		strings.add("");
		
		String encoded = encode(strings);
		System.out.println("----" + encoded + "-----");
		List<String> decoded = decode(encoded);
		for(String s: decoded)
			System.out.println("~~~~" + s + "~~~~");
	}

	private static List<String> decode(String encoded) {

		List<String> result = new ArrayList<>();
		
		if(encoded == null)
			return result;
		
		if(encoded.equals(" | "))
			return result;
		
		for(String s: encoded.split(" \\| ")) {
			result.add(s.replace("||", "|"));
		}
		
		return result;
	}

	private static String encode(List<String> strings) {

		StringBuilder sb = null;
		
		for(String s: strings) {
			sb = new StringBuilder();
			sb.append(s.replace("|", "||")).append(" | ");
		}
		
		return sb != null ? sb.toString() : null;
	}

}
