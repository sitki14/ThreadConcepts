package Reentrant_Lock;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Reentrant_Lock {
	
	private int say=0;
	private Lock lock= (Lock)new Reentrant_Lock();
	private Condition condition=lock.newCondition();
		
	
	public void artir() { //syncronized ile yaz�lmad�g� i�in her thread girebilecek
		for(int i=0;i<10000;i++) {
			say++;
		}
		
	}
	public void thread1Fonk() {
		 lock.lock();
	        System.out.println("Thread 1 �al���yor...");
	        System.out.println("Thread 1 Uyand�r�lmay� Bekliyor....");
	        
	        try {
	            condition.await();
	        } catch (InterruptedException ex) {
	        }
	        System.out.println("Thread 1 Uyand�r�ld� ve ��lemine Devam Ediyor....");
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
	        System.out.println("Thread 2 �al���yor....");
	        artir();
	        System.out.println("Devam etmek i�in bir tu�a bas�n...");
	        scanner.nextLine();
	        condition.signal();
	        System.out.println("Thread 1'i Uyand�rd�m.Ben gidiyorum...");
	       
	        lock.unlock();
		
	}
	public void threadOver() {
		System.out.println("Say de�iskeninin de�eri :"+say);
	}
}
