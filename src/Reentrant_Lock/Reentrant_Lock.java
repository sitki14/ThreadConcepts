package Reentrant_Lock;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Reentrant_Lock {
	
	private int say=0;
	private Lock lock= (Lock)new Reentrant_Lock();
	private Condition condition=lock.newCondition();
		
	
	public void artir() { //syncronized ile yazýlmadýgý için her thread girebilecek
		for(int i=0;i<10000;i++) {
			say++;
		}
		
	}
	public void thread1Fonk() {
		 lock.lock();
	        System.out.println("Thread 1 Çalýþýyor...");
	        System.out.println("Thread 1 Uyandýrýlmayý Bekliyor....");
	        
	        try {
	            condition.await();
	        } catch (InterruptedException ex) {
	        }
	        System.out.println("Thread 1 Uyandýrýldý ve Ýþlemine Devam Ediyor....");
	        artir();
	       
	        
	        lock.unlock();
		
		
	}
	public void thread2Fonk() {	
		  try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ex) {
	        }
	        Scanner scanner = new Scanner(System.in);
	        lock.lock();
	        System.out.println("Thread 2 Çalýþýyor....");
	        artir();
	        System.out.println("Devam etmek için bir tuþa basýn...");
	        scanner.nextLine();
	        condition.signal();
	        System.out.println("Thread 1'i Uyandýrdým.Ben gidiyorum...");
	       
	        lock.unlock();
		
	}
	public void threadOver() {
		System.out.println("Say deðiskeninin deðeri :"+say);
	}
}
