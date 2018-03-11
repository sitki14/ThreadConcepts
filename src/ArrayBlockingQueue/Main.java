package ArrayBlockingQueue;

import java.util.prefs.Preferences;

public class Main {

	public static void main(String[] args) {
		ProducerConsumer sinifRef=new ProducerConsumer();
		
		Thread p=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				sinifRef.produce();
			}
		});
		
		
		Thread c=new Thread(new Runnable() {
			
			@Override
			public void run() {
				sinifRef.consume();
				
			}
		});
		c.start();
		p.start();
		try {	
			p.join();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
