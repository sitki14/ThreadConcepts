
public class deneme {
	Object lock=new Object();

	
	
	public void thread1() { 
		synchronized (lock) {
				
	System.out.println("nerhaba ben thread 1 methodunun ýcýndeyým ");
	System.out.println("sýmdý uykuya dalacam ");
	try {
		System.out.println("merhaba");
		lock.wait();
	} catch (InterruptedException e) {
	}
	System.out.println("uyandým .....");
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
		
		System.out.println("merhaba ben thread 2 methodunun ýcýndeyým ");
		lock.notify();
		System.out.println("uyandýrdým trhead 1 ý ");
	}
		
	
	}

}
