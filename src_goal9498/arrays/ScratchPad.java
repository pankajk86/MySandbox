package arrays;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.Stream;

import trees.TreeNode;

public class ScratchPad {

	public static void main(String[] args) {
		numberPalindrome();
		initializeTwoDimArray();
		mathCeiling();
		testSHA256();
		singleOccurrance();
		System.out.println("~~~~");
		//findMissingNumber();
		resetMatrixLocations();
		intersectList();
		System.out.println("~~~~");
		

		testDataTypeSize();
		testLinkedHashMap();
		testTreeMap();
		testLambdaInComparator();
		testStreamWithCollections();
		testCountBits();
		
		reviseMergeKSortedList();
		reviseIntervalListIntersections();
		reviseDailyTemperaturs();
		reviseFindBottomLeftTreeValue();
		reviseValidateStackSequences();
		reviseSortCharactersByFrequency();
	}



	private static void testCountBits() {
		int n = 37, result = 0;
		System.out.print(n + " -> " + Integer.toBinaryString(n));
		while(n != 0) {
			result += n & 1;
			n = n >> 1;
		}
		System.out.println(result);
	}

	private static void testLambdaInComparator() {
		List<int[]> list = Arrays.asList(new int[] {3, 4}, new int[] {5, 1}, new int[] {7, 5},
		        new int[] {4, 7}, new int[] {6, 2}, new int[] {5, 9} , new int[] {3, 8} ,
		        new int[] {2, 7}, new int[] {1, 6}, new int[] {6, 0});
		
		Collections.sort(list, (a, b) -> {return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]; });
		Collections.sort(list, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
	}
	
	private static void testStreamWithCollections() {
		String[] s = { "3", "30", "34" ,"5" ,"9" };
		Arrays.sort(s, (a, b) -> {
			String s1 = a + b, s2 = b + a;
			return -1 * s1.compareTo(s2);
		});
		
		System.out.println(Arrays.toString(s));
		Stream<String> stream1 = Arrays.stream(s);
		stream1.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		//items.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v));
		
		items.forEach((k, v) -> {
			if(k.equals("B") || k.equals("D")) System.out.println("Blacklisted key: " + k);
			else System.out.println("Key: " + k + ", Value: " + v);
		});
	}

	private static void testTreeMap() {
		long n = 150L;
		TreeMap<Long, Integer> tmap = new TreeMap<>();
		tmap.put(10L, 4); tmap.put(100L, 35); tmap.put(20L, 14); tmap.put(130L, 6);
		
		System.out.println("`````");
		while(n - tmap.firstKey() > 30) {
			tmap.remove(tmap.firstKey());
		}
		System.out.println(tmap);
	}

	private static void intersectList() {
		List<Integer> l1 = new ArrayList<>(Arrays.asList( 5, 4, 3, 7, 1, 6 ));
		List<Integer> l2 = new ArrayList<>(Arrays.asList( 2, 4, 1, 7 ));
		
		List<Integer> result = intersect(l1, l2);
		System.out.println(result);
	}

	private static List<Integer> intersect(List<Integer> l1, List<Integer> l2) {
		Collections.sort(l1); Collections.sort(l2);
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
			int a = l1.get(i), b = l2.get(j);
			if(a < b) i++;
			else if(a > b) j++;
			else {
				result.add(a);
				i++; j++;
			}
		}
		
		return result;
	}

	private static void resetMatrixLocations() {
		int[][] a = new int[10][20];
		for(int i = 0; i < a.length; i++) Arrays.fill(a[i], 1);
		int[][] locs = {{5, 3}, {7, 17}, {6, 8}, {9, 15}, {4, 13}, {4, 2}, {7, 15}, {1, 13}};
		List<int[]> list = new ArrayList<>(Arrays.asList(locs));
		
		resetLocations(a, list);
		
//		for(int i = 0; i < a.length; i++) {
//			for(int j = 0; j < a[0].length; j++)
//				System.out.print(a[i][j] + " ");
//			System.out.println();
//		}
	}

	private static void resetLocations(int[][] a, List<int[]> list) {
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			int[] loc = list.get(i);
			a[loc[0]][loc[1]] = 0;
		}
	}

	@SuppressWarnings("unused")
	private static void findMissingNumber() {
		int[] list = new int[999999999];
		for(int i = 0, j = 1; i < 999999999; i++) {
			list[i] = j;
			j = i != 7000 ? j + 1 : j + 2; // 7002 is missing
		}
		
		int result = missingNumber(list);
		System.out.println(result);
	}

	private static int missingNumber(int[] a) {
		
		int allXor = 1, inputXor = a[0];
		for(int i = 2; i <= 1000000000; i++)
			allXor ^= i;

		for(int i = 1; i < a.length; i++)
			inputXor ^= a[i];
		
		return allXor ^ inputXor;
	}

	private static void singleOccurrance() {
		int[] a = { 1, 4, 1, 1, 2, 3, 4, 4, 5 };
		List<Integer> result = findSingleOccurrance(a);
		System.out.println("Unique Integers: " + result);
	}

	private static List<Integer> findSingleOccurrance(int[] a) {
		List<Integer> result = new ArrayList<>();
		Arrays.sort(a);
		
		for(int i = 0; i < a.length; i++) {
			if(i == 0 && a[i] != a[i + 1]) result.add(a[i]);
			else if(i == a.length - 1 && a[i] != a[i - 1]) result.add(a[i]);
			else if(i > 0 && i < a.length - 1 && a[i] != a[i - 1] && a[i] != a[i + 1]) result.add(a[i]);
		}
		return result;
	}

	private static void reviseSortCharactersByFrequency() {
		String s = "Aabb";
		String result = sortCharacters(s);
		System.out.println(result);
	}

	private static String sortCharacters(String s) {
		if(s == null || s.isEmpty()) return s;
        
        char[] carr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c: carr) map.put(c, map.getOrDefault(c, 0) + 1);
        
        Character[] temp = new Character[carr.length];
        for(int i = 0; i < carr.length; i++) temp[i] = carr[i];
        
        Arrays.sort(temp, new Comparator<Character>() {
			@Override
			public int compare(Character c1, Character c2) {
				if(map.get(c1) > map.get(c2)) return -1;
				return 1;
			}
        });
        
        StringBuilder sb = new StringBuilder();
        for(char c: temp) sb.append(c);
        
        return sb.toString();
 
	}

	private static void reviseValidateStackSequences() {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 3, 2, 1 };
		
		boolean result = validateStackSequences(push, pop);
		System.out.println(result);
	}

	private static boolean validateStackSequences(int[] push, int[] pop) {
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		
		for(int i = 0; i < push.length; i++) {
			stack.push(push[i]);
			if(push[i] == pop[j]) {
				while(!stack.isEmpty() && stack.peek() == pop[j]) {
					stack.pop();
					j++;
				}
			}
		}
		
		while(j < pop.length) {
			if(!stack.isEmpty() && stack.peek() == pop[j]) {
				stack.pop();
				j++;
			} else return false;
		}

		return stack.isEmpty();
	}

	private static void reviseFindBottomLeftTreeValue() {
		TreeNode root = createTree1();
		int result = findBottomLeftValue(root);
		System.out.println(result);
	}

	private static int findBottomLeftValue(TreeNode root) {
		int result = root.val;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.addAll(Arrays.asList(root, null));
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			} else {
				if(q.size() > 0) {
					result = q.peek().val;
					q.add(null);
				}
			}
		}
		
		return result;
	}

	private static TreeNode createTree1() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n4; n5.left = n7;
		n3.left = n5; n3.right = n6;
		n1.left = n2; n1.right = n3;
		return n1;
	}

	private static void reviseDailyTemperaturs() {
		int[] temp = { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 };
		int[] result = dailyTemperatures(temp);
		for(int r: result) System.out.print(r + " ");
		System.out.println();
	}

	private static int[] dailyTemperatures(int[] a) {
		if(a == null || a.length == 0) return null;
		
		int[] result = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		result[a.length - 1] = 0;
		stack.push(a.length - 1);
		
		for(int i = a.length - 2; i >= 0; i--) {
			while(!stack.isEmpty() && a[stack.peek()] <= a[i])
				stack.pop();
			result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		
		return result;
	}

	private static void reviseIntervalListIntersections() {
		int[][] a = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] b = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		int[][] result = intervalIntersections(a, b);
		for(int[] interval : result) System.out.println(interval[0] + ", " + interval[1]);
	}

	private static int[][] intervalIntersections(int[][] a, int[][] b) {
		List<int[]> list = new ArrayList<>();
        if(a == null || b == null) return null;
        
        for(int i = 0, j = 0; i < a.length && j < b.length; ) {
            int start = Math.max(a[i][0], b[j][0]);
            int end = Math.min(a[i][1], b[j][1]);
            
            if(end >= start) list.add(new int[] {start, end});
            if(end == a[i][1]) i++;
            if(end == b[j][1]) j++;
        }
        
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        
        return result;
	}

	private static void reviseMergeKSortedList() {
		List<List<Integer>> list = new ArrayList<>();
		list.addAll(Arrays.asList(
				Arrays.asList(5, 10, 12), // 2, 4, 
				Arrays.asList(1, 3, 8),
				Arrays.asList(6, 9)
		));
		
		List<Integer> result = merge(list);
		System.out.println(result);
	}

	private static List<Integer> merge(List<List<Integer>> list) {
		
		List<Integer> result = new ArrayList<>();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return list.get(a[0]).get(a[1]) - list.get(b[0]).get(b[1]);
			}
		});
		
		for(int i = 0; i < list.size(); i++) {
			pq.add(new int[] {i, 0});
		}
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			result.add(list.get(curr[0]).get(curr[1]));
			if(curr[1] < list.get(curr[0]).size() - 1) {
				pq.add(new int[] {curr[0], curr[1] + 1});
			}
		}
		
		return result;
	}

	private static void testLinkedHashMap() {
		
		System.out.println("LinkedHashMap:");
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "test1");
		map.put(3, "test3");
		map.put(2, "test2");
		
		for(Map.Entry<Integer, String> entry: map.entrySet())
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		
		System.out.println("TreeMap:");
		TreeMap<Integer, String> map2 = new TreeMap<>();
		map2.put(1, "test1");
		map2.put(3, "test3");
		map2.put(2, "test2");
		
		for(Map.Entry<Integer, String> entry: map2.entrySet())
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		
		System.out.println("HashMap:");
		TreeMap<Integer, String> map3 = new TreeMap<>();
		map3.put(1, "test1");
		map3.put(3, "test3");
		map3.put(2, "test2");
		
		for(Map.Entry<Integer, String> entry: map3.entrySet())
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		
	}

	private static void testDataTypeSize() {
		char c = 'a';
		System.out.println(c + "->" + Integer.toBinaryString(c));
		c = 'z';
		System.out.println(c + "->" + Integer.toBinaryString(c));
		c = '\u0986'; // 0000 0011 1010 1001
		System.out.println(c + "->" + Integer.toBinaryString(c));

		char[] carr = { '\u092A', '\u0902', '\u0915', '\u091C' }; // my first name in Hindi :)
		String s = String.valueOf(carr);
		System.out.println(s);

		c = 'Ҧ';
		int x = (int) c;
		System.out.println(c + "->" + Integer.toBinaryString(c) + " -> " + x);
	}

	private static void testSHA256() {
		String url = "http://www.educative.io/distributed.php?id=design, and http://www.educative.io/distributed.php%3Fid%3Ddesign";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");// ("SHA-256");
			byte[] encoded = digest.digest(url.getBytes(StandardCharsets.UTF_8));
			BigInteger num = new BigInteger(1, encoded);
			String hash = num.toString(16);

			while (hash.length() < 32)
				hash = "0" + hash;

			System.out.println(hash);

			String base64Encoded = Base64.getEncoder().encodeToString(hash.getBytes("UTF-8"));
			System.out.println(base64Encoded);

			System.out.println(Base64.getEncoder().encodeToString("2".getBytes("UTF-8")));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void mathCeiling() {
		int n = 5;
		double result = Math.ceil((double) n / 2);
		System.out.println(result);
	}

	private static void initializeTwoDimArray() {
		int[][] result = new int[3][2];
		int[] a = { 1, 2 };
		result[0] = a;
		result[1] = a;
		result[2] = new int[] { 1, 2 };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++)
				System.out.print(result[i][j]);
			System.out.println();
		}
	}

	private static void numberPalindrome() {
		int n = 12321;
		int p = n, m = 0;

		while (n > 0) {
			int r = n % 10;
			n /= 10;
			m = 10 * m + r;
		}

		System.out.println(m == p);
	}

}
