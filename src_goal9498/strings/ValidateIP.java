package strings;

public class ValidateIP {

	public static void main(String[] args) {
		String ip = "192.1.0.1"; // "2001:0db8:85a3:0:0:8A2E:0370:7334:"; // 
		String result = validate(ip);
		System.out.println(result);
	}

	private static String validate(String ip) {
		
		String temp = ip.replaceAll("\\s+", "");
		
		if(ip.isEmpty() || ip.length() - temp.length() > 0) {
			return "Neither";
		}
		
		if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.'
				|| ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':') {
			return "Neither";
		}
		
		String[] t1 = ip.split("\\.");
		String[] t2 = ip.split(":");
		
		if(t1.length == 4) {
			return validateIPv4(t1);
		} else if(t2.length == 8) {
			return validateIPv6(t2);
		} else {
			return "Neither";
		}
	}

	private static String validateIPv4(String[] parts) {
		boolean flag = true;
		
		for(String s: parts) {
			
			if(s.isEmpty() || s.length() > 3 || (s.charAt(0) == '0' && s.length() > 1)) {
				flag = false;
				break;
			}
			
			for(char c: s.toCharArray()) {
				if(!isValidDecimal(c)) {
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				break;
			}
			
			int n = Integer.parseInt(s);
			if(n < 0 || n > 255) {
				flag = false;
				break;
			}
		}
		
		return flag ? "IPv4" : "Neither";
	}

	private static String validateIPv6(String[] parts) {
		boolean flag = true;
		
		for(String s: parts) {
			if(s.isEmpty() || s.length() > 4) {
				flag = false;
				break;
			}
			
			String temp = s.toLowerCase();
			
			for(char c: temp.toCharArray()) {
				if(!isValidHex(c)) {
					flag = false;
					break;
				}
			}
			
			if(!flag) {
				break;
			}
		}
		
		return flag ? "IPv6" : "Neither";
	}
	
	private static boolean isValidDecimal(char c) {
		String validDecimal = "0123456789";
		return validDecimal.indexOf(c) >= 0;
	}

	private static boolean isValidHex(char c) {
		String validHexCodes = "0123456789abcdef";
		return validHexCodes.indexOf(c) >= 0;
	}

}
