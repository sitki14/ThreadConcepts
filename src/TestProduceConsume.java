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
			synchronized (lock){//kim lock u daha �nce kaparsa bu blok ona ait olacak.
				//ve biz wait ve notify methodlar� kullanarak lock u b�rakt�racaz.
				if(queue.size()==limit) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
					}
				}
				Integer value=rnd.nextInt(100);
				queue.offer(value);
				System.out.println("produce �retiyor..."+value);
				//g�venlik a��s�ndan 
				lock.notify();//uyuyan consumer varsa uyand�r�r�z
				
				
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
				System.out.println("Consumer T�ketiyor: "+value);
				System.out.println("queue size : "+queue.size());
				lock.notify();//bekleyen producer varsa uyand�r�r�z.
				
			}
			
		}
	}

}
