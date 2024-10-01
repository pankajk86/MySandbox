package uber;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignRateLimiter {

	public static void main(String[] args) {
		test1();
		testing();
		test2();
	}
	
	
	private static void test2() {
		RateLimiter2 rl = new RateLimiter2();
		long t1 = System.currentTimeMillis();
		long t2 = t1 + 10;
		long t3 = t1 + 20;
		
		long t4 = t1 + 1000;
		long t5 = t4 + 10;
		long t6 = t4 + 20;
		long t7 = t4 + 30;
		
		System.out.println(rl.isAllowed("u1", t1));
		System.out.println(rl.isAllowed("u1", t2));
		System.out.println(rl.isAllowed("u2", t3));
		System.out.println(rl.isAllowed("u1", t3));
		System.out.println(rl.isAllowed("u1", t4));
		System.out.println(rl.isAllowed("u2", t5));
		System.out.println(rl.isAllowed("u2", t6));
		System.out.println(rl.isAllowed("u2", t7));
	}


	private static void testing() {
		Queue<Integer> q = new LinkedList<>();
		test(q);
		System.out.println(q);		
	}


	private static void test1() {
		RateLimiter rl = new RateLimiter();
		long t1 = System.currentTimeMillis();
		long t2 = t1 + 10;
		long t3 = t1 + 20;
		
		long t4 = t1 + 1000;
		long t5 = t4 + 10;
		long t6 = t4 + 20;
		
		System.out.println(rl.hit(t1));
		System.out.println(rl.hit(t2));
		System.out.println(rl.hit(t3));
		System.out.println(rl.hit(t4));
		System.out.println(rl.hit(t5));
		System.out.println(rl.hit(t6));
	}
	
	private static void test(Queue<Integer> q) {
		q.add(1);
	}

}

// token bucket rate-limiter
class RateLimiter {
	private final int REQUEST_LIMIT = 2;
	private final long TIME_LIMIT = 1000L; // in 1 second
	
	private final Queue<Long> q = new LinkedList<>();

	public boolean hit(long timestamp) {
		while(!q.isEmpty() && timestamp - q.peek() >= TIME_LIMIT)
			q.poll();
		if(q.size() < REQUEST_LIMIT) {
			q.add(timestamp);
			return true;
		}
		return false;
	}
}

class RateLimiter2 {
	private final int REQUEST_LIMIT = 2;
	private final long TIME_LIMIT = 1000L; // in 1 second
	
	private final Map<String, Queue<Long>> map = new HashMap<>();

	private boolean hit(Queue<Long> q, long timestamp) {
		while(!q.isEmpty() && timestamp - q.peek() >= TIME_LIMIT)
			q.poll();
		if(q.size() < REQUEST_LIMIT) {
			q.add(timestamp);
			return true;
		}
		return false;
	}
	
	public boolean isAllowed(String userId, long timestamp) {
		Queue<Long> q = map.getOrDefault(userId, new LinkedList<>());
		boolean result = hit(q, timestamp);
		if(q.size() == 1)
			map.put(userId, q);
		
		return result;
	}
}