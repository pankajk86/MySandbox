package google;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OnlineElection {

	public static void main(String[] args) {
		int[] persons = { 0, 1, 1, 0, 0, 1, 0 };
		int[] times = { 0, 5, 10, 15, 20, 25, 30 };
		
		TopVotedCandidate tvc = new TopVotedCandidate(persons, times);
		System.out.println(tvc.q(3));
		System.out.println(tvc.q(12));
		System.out.println(tvc.q(25));
		System.out.println(tvc.q(15));
		System.out.println(tvc.q(24));
		System.out.println(tvc.q(8));
	}

}

class TopVotedCandidate {
	private TreeMap<Integer, Integer> map = new TreeMap<>();

	public TopVotedCandidate(int[] persons, int[] times) {

		Map<Integer, Integer> count = new HashMap<>();
		int mostRecentCandidate = -1, mostRecentCount = 0;

		for (int i = 0; i < persons.length; i++) {
			int person = persons[i];
			count.put(person, count.getOrDefault(person, 0) + 1);

			if (count.get(person) >= mostRecentCount) {
				mostRecentCandidate = person;
				mostRecentCount = count.get(person);
			}
			map.put(times[i], mostRecentCandidate);
		}
	}

	public int q(int t) {
		return map.floorEntry(t).getValue();
	}
}
