package demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		Task callable = new Task();
		FutureTask<String> futureTask = new FutureTask<String>(callable) {

			@Override
			protected void done() {
				System.out.println("当前的池"+Thread.currentThread().getName());
				super.done();
			}
		};
		
		ExecutorService executor= Executors.newCachedThreadPool();
		
		executor.execute(futureTask);
		
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static class Task implements Callable<String> {

		@Override
		public String call() throws Exception {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(100);
			}
			return "返回值" + System.currentTimeMillis();
		}

	}

}
