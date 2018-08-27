package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindAndReplaceInString {

	public static void main(String[] args) {
		String s = "mhnbzxkwzxtaanmhtoirxheyanoplbvjrovzudznmetkkxrdmr";
		int[] indexes = { 46,29,2,44,31,26,42,9,38,23,36,12,16,7,33,18 };
		String[] sources = { "rym","kv","nbzxu","vx","js","tp","tc","jta","zqm","ya","uz","avm","tz","wn","yv","ird" }; 
		String[] targets = { "gfhc","uq","dntkw","wql","s","dmp","jqi","fp","hs","aqz","ix","jag","n","l","y","zww" };
		String result = findAndReplace(s, indexes, sources, targets);
		System.out.println(result);
	}

	private static String findAndReplace(String s, int[] indexes, String[] sources, String[] targets) {

		List<Replacer> replacers = new ArrayList<>();

		for (int i = 0; i < indexes.length; i++) {
			Replacer replacer = new Replacer(indexes[i], sources[i], targets[i]);
			replacers.add(replacer);
		}

		Collections.sort(replacers, new Comparator<Replacer>() {
			@Override
			public int compare(Replacer r1, Replacer r2) {
				if (r1.index < r2.index)
					return -1;
				else if (r1.index > r2.index)
					return 1;
				return 0;
			}
		});

		int si = 0, ri = 0;
		StringBuilder sb = new StringBuilder();

		while (si < replacers.get(0).index) {
			sb.append(s.charAt(si));
			si++;
		}

		for (int i = si; i < s.length();) {
			Replacer current = replacers.get(ri);
			String source = current.source;
			int sl = source.length();

			if (current.index == i && s.substring(i, i + sl).equals(source)) {
				sb.append(current.target);
				i += sl;
				if(ri < replacers.size() - 1) ri++;
			} else {
				sb.append(s.charAt(i));
				i++;
				if(i > current.index && ri < replacers.size() - 1) ri++;
			}
		}

		return sb.toString();
	}

}

class Replacer {
	int index;
	String source, target;

	Replacer(int index, String source, String target) {
		this.index = index;
		this.source = source;
		this.target = target;
	}
}
