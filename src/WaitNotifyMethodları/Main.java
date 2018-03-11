package WaitNotifyMethodlarý;

public class Main {

	public static void main(String[] args) {
		WaitNotify wn=new WaitNotify();
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				wn.thread1Fonk();
				
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
			wn.thread2Fonk();
				
			}
		});
		
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
