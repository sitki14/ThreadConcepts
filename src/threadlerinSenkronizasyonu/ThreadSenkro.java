package threadlerinSenkronizasyonu;


	
	public class ThreadSenkro{
		int refSayi = 0;
		
		public synchronized void artir() {
			refSayi++;
		}
		
		public void threadSenk() {
		
			System.out.println("threadSenkro meythoduna girildi");
			Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("selam ben t1 thread iyim");
				for(int i=0;i<10000;i++) {
					artir();
					
				}
				
			}	
		});
		Thread t2=new Thread(new Runnable(){
			
			@Override
			public void run() {
				System.out.println("selam ben t2 threadiyim");
				for(int i=0;i<10000;i++) {
					artir();
					
					
				}
				
			}
		});
		
		
	
		
			
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("threadsenkro dan cýkýldý");
		
		System.out.println("refSayi nin degeri :"+refSayi); //bu nu t1.join den sonra yazmak gerekli. cunku bu main threadýnýn iþi ve beklemeye ldýrdýk 
	}
		
	

	public static void main(String[] args) {
		ThreadSenkro c1=new  ThreadSenkro();
		c1.threadSenk();
		

	}

}
