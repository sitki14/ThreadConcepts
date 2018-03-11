
public class Test {

	public static void main(String[] args) {
		TestProduceConsume pc=new TestProduceConsume();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.produce();
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				pc.consume();
			}
		});
		t1.start();
		t2.start();
		 
		
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
		}

	}

}
