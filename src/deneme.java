
public class deneme {
	Object lock=new Object();

	
	
	public void thread1() { 
		synchronized (lock) {
				
	System.out.println("nerhaba ben thread 1 methodunun �c�ndey�m ");
	System.out.println("s�md� uykuya dalacam ");
	try {
		System.out.println("merhaba");
		lock.wait();
	} catch (InterruptedException e) {
	}
	System.out.println("uyand�m .....");
		}

	}
	public synchronized void thread2 (){
	   try {
		Thread.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  synchronized (lock) {
		
		System.out.println("merhaba ben thread 2 methodunun �c�ndey�m ");
		lock.notify();
		System.out.println("uyand�rd�m trhead 1 � ");
	}
		
	
	}

}
