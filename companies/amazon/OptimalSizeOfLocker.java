package amazon;

import java.util.HashMap;
import java.util.Map;

public class OptimalSizeOfLocker {

	public static void main(String[] args) {
		LockerAssigner la = new LockerAssigner();
		
		Locker locker = la.getLocker('s');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('s');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('l');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('s');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('s');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('m');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('m');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('l');
		System.out.println(locker.id + "->" + locker.type);
		locker = la.getLocker('m');
		System.out.println(locker.id + "->" + locker.type);
	}

}


class LockerAssigner {
	private static final int MAX_COUNT = 3;
	private Map<Character, Integer> map = new HashMap<>();
	
	public Locker getLocker(char bag) {
		char key = getEntry(bag);
		int lockerId = map.getOrDefault(key, 0) + 1;
		map.put(key, lockerId);
		return new Locker(lockerId, key);
	}

	private char getEntry(char type) {
		if(type == 'n') return type;
		
		int count = map.getOrDefault(type, 0);
		if(count < MAX_COUNT) return type;
		else return getEntry(type == 's' ? 'm' : (type == 'm' ? 'l' : 'n'));
	}
}


class Locker {
	int id;
	char type;
	
	Locker(int id, char type) {
		this.id = id;
		this.type = type;
	}
}
