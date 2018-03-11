package ArrayBlockingQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
	Random rnd=new Random();
	BlockingQueue<Integer> queue=new ArrayBlockingQueue<Integer>(10);
	int value;
	public void produce() {
		while(true) {
			try {
				
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			value=rnd.nextInt(100);
			try {
				queue.put(value);
				System.out.println("put methodu çalýstý :"+value);
				System.out.println("Þuanda produce methodundayýz kuyruk uzunlugu\n"+queue.size()+"\n");
			} catch (InterruptedException e) {
			}
			
		}
	}
	public void consume() {
		while(true) {
			
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
			}
			try {
				Integer value=queue.take();
				System.out.println("take methodu çalýstý :"+value);
				System.out.println("Þuanda produce methodundayýz kuyruk uzunlugu \n"+queue.size()+"\n");
			} catch (InterruptedException e) {
			}
		}
		
	}
	

}
