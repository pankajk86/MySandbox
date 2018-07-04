package maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = { 55, 38, 53, 81, 61, 93, 97, 32, 43, 78 };
		int[] result = dailyTemperatures(temperatures);

		for (int i : result) {
			System.out.print(i + ", ");
		}
	}

	private static int[] dailyTemperatures(int[] temperatures) {

		int[] result = new int[temperatures.length];
		Set<Temp> cold = new HashSet<>();
		Map<Integer, Temp> map = new HashMap<>();

		cold.add(new Temp(temperatures[0], 0));
		map.put(0, null);

		for (int i = 1; i < temperatures.length; i++) {
			Temp current = new Temp(temperatures[i], i);
			map.put(i, null);

			if (!cold.isEmpty()) {
				Iterator<Temp> iterator = cold.iterator();

				while (iterator.hasNext()) {
					Temp t = iterator.next();
					if (t.temp < current.temp) {
						map.put(t.day, current);
						iterator.remove();
					}
				}
			}
			cold.add(current);
		}

		int i = 0;
		for (Map.Entry<Integer, Temp> entry : map.entrySet()) {
			Temp t = entry.getValue();
			if (t != null) {
				result[i] = t.day - entry.getKey();
			}
			i++;
		}

		return result;
	}

}

class Temp {
	int temp;
	int day;

	public Temp(int temp, int day) {
		this.temp = temp;
		this.day = day;
	}
}
