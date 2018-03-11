package threadlerinSenkronizasyonu;

public  class ThreadSafe implements Runnable {
	
	private int count =0;
	
	public  synchronized void artir() {
		//bu methoda synchronized anahtar kelimesini ekleyerek t1 ýn iþi bitmeden diðer thread ýn girmesini engelleedi.
		count++;
	}
	
	
	public void threadleriCalistir() throws InterruptedException {
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5000;i++){
					artir();
				}
			}
		});

		
		
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<5000;i++){
					artir();
					
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Count deðiþkeninin deðeri :"+count);
	}
	public static void main(String[] args) throws InterruptedException {
		
	ThreadSafe threadsafe=new ThreadSafe();
	threadsafe.threadleriCalistir();
	System.out.println();
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
