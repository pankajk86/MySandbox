package microsoft;

public class CompareVersionNumbers {

	public static void main(String[] args) {
		String version1 = "1.0.1", version2 = "1";
		int result = compareVersions(version1, version2);
		System.out.println(result);
	}

	private static int compareVersions(String version1, String version2) {

		String[] s1 = version1.split("\\."), s2 = version2.split("\\.");
		int i = 0, j = 0;
		
		for(; i < s1.length && j < s2.length; i++, j++) {
			int p1 = Integer.parseInt(s1[i]), p2 = Integer.parseInt(s2[j]);
			if(p1 > p2) return 1;
			if(p1 < p2) return -1;
		}
		
		if(i < s1.length) {
			while(i < s1.length) {
				if(Integer.parseInt(s1[i]) > 0) return 1;
				i++;
			}
			return 0;
		}
		
		if(j < s2.length) {
			while(j < s2.length) {
				if(Integer.parseInt(s2[j]) > 0) return -1;
				j++;
			}
			return 0;
		}
		
		return 0;
	}

}
