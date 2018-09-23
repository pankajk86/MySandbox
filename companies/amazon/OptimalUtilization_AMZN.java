package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OptimalUtilization_AMZN {

	public static void main(String[] args) {
		List<List<Integer>> fgApps = createFGApps();
		List<List<Integer>> bgApps = createBGApps();
		int cap = 10;
		
		List<List<Integer>> result = optimalUtilization(cap, fgApps, bgApps);
		System.out.println(result);
	}



	private static List<List<Integer>> optimalUtilization(int deviceCapacity, List<List<Integer>> foregroundAppList,
			List<List<Integer>> backgroundAppList) {
		
		List<List<Integer>> result = new ArrayList<>();
		List<Pair> pairs = new ArrayList<>();
		
		for(List<Integer> fg: foregroundAppList) {
			for(List<Integer> bg: backgroundAppList) {
				int fgId = fg.get(0), bgId = bg.get(0);
				int req = fg.get(1) + bg.get(1);
				pairs.add(new Pair(fgId, bgId, req));
			}
		}
		
		Collections.sort(pairs, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.req < p2.req) return -1;
				else if(p1.req > p2.req) return 1;
				return 0;
			}
		});
		
		int optimalMemory = 0;
		
		for(int i = pairs.size() - 1; i >= 0; i--) {
			Pair pair = pairs.get(i);
			if(pair.req <= deviceCapacity && optimalMemory == 0) {
				optimalMemory = pair.req;
				break;
			}
		}
		
		for(Pair pair: pairs) {
			if(pair.req == optimalMemory) {
				List<Integer> appPair = new ArrayList<>();
				appPair.addAll(Arrays.asList(pair.fgId, pair.bgId));
				result.add(appPair);
			}
		}
		
		return result;
	}

	
	private static List<List<Integer>> createBGApps() {
		List<List<Integer>> bg = new ArrayList<>();
		
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 2));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 3));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(3, 4));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(4, 5));
		
		bg.addAll(Arrays.asList(l1, l2, l3, l4));
		
		return bg;
	}

	private static List<List<Integer>> createFGApps() {
		List<List<Integer>> bg = new ArrayList<>();
		
		List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 3));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 5));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(3, 7));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(4, 10));
		
		bg.addAll(Arrays.asList(l1, l2, l3, l4));
		
		return bg;
	}
}


class Pair {
	int fgId, bgId, req;
	
	public Pair(int fgId, int bgId, int req) {
		this.fgId = fgId; this.bgId = bgId; this.req = req;
	}
}
