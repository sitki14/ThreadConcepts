package WaitNotifyMethodlarý;

import java.util.Scanner;

public class WaitNotify {
	private Object lock=new Object();
	public  void thread1Fonk() {
		synchronized (lock) {
			
		}
		//synchronized (this) {// bu onerýlmýyor 
			//bunun  yerine lock kullanýlabýlýr
			/*burada lock kullanýlmadý ben burada thýs anahtar kelýmesýnýn kullanarak 
			 * ben burada bu objemýn uzerinde yapacaguým anlamýna gelir */
			System.out.println("Thread 1 Çlýsýyor...");
			System.out.println("Thread 1 Thread 2 nýn kendýsýný uyandýrmasýný beklýyor...");
			
			//burada wait methýodunu kullanacaz
			//this.wait(); // de olur 7
			try {
				lock.wait();//objecyt classýnda gelen býr method
				//burada thread uykuya gecer anahtarý býrakýr ve baskasý gelýp bu thread ý uyandýrana kadar bu thread calýsmaz. 
				
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 1 uyandý devam ediyor . Günaydýn ...:D");
		}
	
	public void thread2Fonk() {
		Scanner sc=new Scanner (System.in);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		} //burada threadý 2 n uyutuyoruz 
		//uyutmamýzýn nedený thread 1 2 sn boyunca anahtarý alsýn dýye 
	//	synchronized (this) 
		synchronized (lock) {
			
		}{
			System.out.println("Thread 2 çalýsýyor.");
			System.out.println("devam etmak için býr tusa basýn ");
			sc.nextLine();
			//iþ bitti diðer thread ý uyandýrmak için 
		    lock.notify();
			System.out.println("uyandý thread 1 ama ben blok u terkeden kadar bekleyecek yýne ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
	}
}
