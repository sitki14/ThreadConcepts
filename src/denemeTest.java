
public class denemeTest {
	public static void main(String[] args) {
		System.out.println("ben main methodunun nýcýndeyým ");
		deneme deneme2 =new deneme();
			deneme deneme1=new deneme();
		Thread t1 =new Thread (new Runnable() {
			
			@Override
			public void run() {
				deneme1.thread1();}
			
			}
		
		);
		
		Thread t2=new Thread (new Runnable() {
			
			@Override
			public void run() {
			deneme1.thread2();
			}
		}
			
		
		);
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		System.out.println("selam");
	}

}
