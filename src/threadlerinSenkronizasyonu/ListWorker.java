package threadlerinSenkronizasyonu;

public class ListWorker {

	public static void main(String[] args) {
		Thread t1=new Thread(new Runnable() {
		
		@Override
		public void run() {
			System.out.println("selam ben run methodunun i�indeyim");
			
		}
	});
	t1.start();
		
	}
}


