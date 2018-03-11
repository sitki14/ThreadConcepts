package ThreadleriYar�daKesme;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> list=new LinkedList<Integer>();
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread cal�s�yor");
				
				for(int i=0;i<10000000;i++) {
					//ilk olarak bana herhangi bir interrupt yap�ld�m� diye kontrol etmak gerekir 
					if(Thread.currentThread().isInterrupted()) {
						/*burda interrupt olup olmad�g�n� thread�n 
						kendi fonks�yonu �le kontrol ett�k ve bunlar 
						true ya da false degeri d�ner ilk basta bu 
						thread�m�z uzerinde methdonunu cag�ord�k sonra 
						interrupt methodunu cag�rd�kk ve bunu saglad�k */
						System.out.println("Kesintiye Ugrad�...");
						//bu sekilde program� 
						return ;
						
					}
					list.add(i);
					
					
				}
				
				
				

				/*for(int i=1;i<=10;i++) {
					System.out.println("thread yaz�yor");
					try {
						Thread.sleep(1000);
						System.out.println("uykumun  "+i+" . saniyesindeyim");
					} catch (InterruptedException e) {
						//thread uyudugu zaman o s�rada bir tane interrupt gelirse interrupt a girer thread 
						// bitirmez yar�da keser.
						System.out.println("uykum b�l�nd�...");
					}
				}*/
				System.out.println("thread kesintiye ugramad� i�ini bitirdi.");
				
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
