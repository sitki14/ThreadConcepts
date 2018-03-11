import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestProduceConsume {
	Random rnd=new Random();
	Object lock=new Object();
	Queue<Integer> queue=new LinkedList<Integer>();
	private int limit=10;
	public void produce () {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			synchronized (lock){//kim lock u daha önce kaparsa bu blok ona ait olacak.
				//ve biz wait ve notify methodlarý kullanarak lock u býraktýracaz.
				if(queue.size()==limit) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				Integer value=rnd.nextInt(100);
				queue.offer(value);
				System.out.println("produce üretiyor..."+value);
				//güvenlik açýsýndan 
				lock.notify();//uyuyan consumer varsa uyandýrýrýz
				
				
			}
		}
	}
	public void consume() {
		while(true) {
			try {
				Thread.sleep(1300);
			} catch (InterruptedException e) {
			}
			synchronized (lock) {
				if(queue.size()==0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
					
				}
				Integer value=queue.poll();
				System.out.println("Consumer Tüketiyor: "+value);
				System.out.println("queue size : "+queue.size());
				lock.notify();//bekleyen producer varsa uyandýrýrýz.
				
			}
			
		}
	}

}
