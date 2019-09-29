package multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i = 0; i < 100000000; i++) list.add(rand.nextInt(100));
		
		long start = System.currentTimeMillis();
		int result = singleThreadedSum(list);
		System.out.println("Result: " + result + ", Time Taken: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		result = multiThreadedSum(list);
		System.out.println("Result: " + result + ", Time Taken: " + (System.currentTimeMillis() - start));
		
		/*
		 Result: 495013485, Time Taken: 63
		 Result: 495013485, Time Taken: 163
		 */
	}

	private static int multiThreadedSum(List<Integer> list) {
		int nThreads = 100, chunkSize = list.size() / nThreads;
		ExecutorService executor = Executors.newFixedThreadPool(nThreads);
		List<Future<Integer>> futureList = new ArrayList<>();
		
		for(int i = 0; i < nThreads; i++) {
			int start = chunkSize * i, end = (chunkSize * i) + chunkSize;
			List<Integer> chunk = list.subList(start, end);
			
			Future<Integer> future = executor.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int result = 0;
					for(int i: chunk) result += i;
					return result;
				}
			});
			
			futureList.add(future);
		}
		int result = 0;
		try {
			for(Future<Integer> future: futureList)
			result += future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executor.shutdown();
		return result;
	}

	private static int singleThreadedSum(List<Integer> list) {
		int result = 0;
		for(int i: list) result += i;
		return result;
	}

}
