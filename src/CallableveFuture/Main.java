package CallableveFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor=Executors.newFixedThreadPool(3);
		executor.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Merhaba Dünya...");
				
			}
		});
		executor.shutdown();
		//DEGER DÖNDÜRMEK ÝÇÝN NEW CALLABLE SINIFI TERCIH EDILMELIDIR
		ExecutorService executor1=Executors.newFixedThreadPool(1);
		Future<Integer> f=executor1.submit(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("Hello World...");
				int deger=0;
				
				return deger;
			}
		});
		try {
			System.out.println("Deger deðiþkeninin Deðeri: "+f.get());
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}

	}

}
