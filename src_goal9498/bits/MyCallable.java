package bits;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyCallable implements Callable<String> {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		Callable<String> callable = new MyCallable();
		List<Future<String>> list = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			Future<String> future = executor.submit(callable);
			list.add(future);
		}
		
		for(Future<String> future: list) {
			try {
				System.out.println(new Date() + "::" + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "Current Thread Name: " + Thread.currentThread().getName();
	}

}
