package ThreadleriYarýdaKesme;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list=new LinkedList<Integer>();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread calýsýyor");
				
				for(int i=0;i<10000000;i++) {
					//ilk olarak bana herhangi bir interrupt yapýldýmý diye kontrol etmak gerekir 
					if(Thread.currentThread().isInterrupted()) {
						/*burda interrupt olup olmadýgýný threadýn 
						kendi fonksýyonu ýle kontrol ettýk ve bunlar 
						true ya da false degeri döner ilk basta bu 
						threadýmýz uzerinde methdonunu cagýordýk sonra 
						interrupt methodunu cagýrdýkk ve bunu sagladýk */
						System.out.println("Kesintiye Ugradý...");
						//bu sekilde programý 
						return ;
						
					}
					list.add(i);
					
					
				}
				
				
				

				/*for(int i=1;i<=10;i++) {
					System.out.println("thread yazýyor");
					try {
						Thread.sleep(1000);
						System.out.println("uykumun  "+i+" . saniyesindeyim");
					} catch (InterruptedException e) {
						//thread uyudugu zaman o sýrada bir tane interrupt gelirse interrupt a girer thread 
						// bitirmez yarýda keser.
						System.out.println("uykum bölündü...");
					}
				}*/
				System.out.println("thread kesintiye ugramadý iþini bitirdi.");
				
			}
		});
		t.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.interrupt();

	}

}
