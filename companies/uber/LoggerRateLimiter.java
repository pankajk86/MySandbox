package uber;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

	public static void main(String[] args) {
		Logger logger = new Logger();
		
		System.out.println(logger.shouldPrintMessage(1, "foo"));
		System.out.println(logger.shouldPrintMessage(2, "bar"));
		System.out.println(logger.shouldPrintMessage(3, "foo"));
		System.out.println(logger.shouldPrintMessage(8, "bar"));
		System.out.println(logger.shouldPrintMessage(10, "foo"));
		System.out.println(logger.shouldPrintMessage(11, "foo"));
	}

}

class Logger {
	private Map<String, Integer> map;
	
	Logger() {
		this.map = new HashMap<>();
	}
	
	public boolean shouldPrintMessage(int timestamp, String message) {
		
		if(!map.containsKey(message)) {
			map.put(message, timestamp);
			return true;
		} else {
			int timeDiff = timestamp - map.get(message);
			if(timeDiff < 10) {
				return false;
			} else {
				map.put(message, timestamp);
				return true;
			}
		}
	}
}