package threadOlusturma;

public class Printer extends Thread {
	private String isim;
					
	public Printer(String isim) {
		super();
		this.isim = isim;
		
	}

	@Override
	public void run() {
		System.out.println("merhaba ben run methodunun i�iinde �al�s�yorum");
		for(int i=0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {System.out.println("thread kesintiye ugrad�");
			}
		}
	}

	

}
