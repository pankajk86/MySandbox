package linkedin;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static void main(String[] args) {
		String[] emails = {
				"test.email+alex@leetcode.com",
				"test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com"
		};
		
		int result = countUnqiueEmails(emails);
		System.out.println(result);
	}

	private static int countUnqiueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		
		for(String s: emails) {
			String[] parts = s.split("@");
			String replaced = parts[0].replace(".", "");
			String filtered = replaced.substring(0, replaced.indexOf('+'));
			set.add(filtered + "@" + parts[1]);
		}
		
		return set.size();
	}

}
