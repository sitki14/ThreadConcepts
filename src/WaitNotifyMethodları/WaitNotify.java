package WaitNotifyMethodlar�;

import java.util.Scanner;

public class WaitNotify {
	private Object lock=new Object();
	public  void thread1Fonk() {
		synchronized (lock) {
			
		}
		//synchronized (this) {// bu oner�lm�yor 
			//bunun  yerine lock kullan�lab�l�r
			/*burada lock kullan�lmad� ben burada th�s anahtar kel�mes�n�n kullanarak 
			 * ben burada bu objem�n uzerinde yapacagu�m anlam�na gelir */
			System.out.println("Thread 1 �l�s�yor...");
			System.out.println("Thread 1 Thread 2 n�n kend�s�n� uyand�rmas�n� bekl�yor...");
			
			//burada wait meth�odunu kullanacaz
			//this.wait(); // de olur 7
			try {
				lock.wait();//objecyt class�nda gelen b�r method
				//burada thread uykuya gecer anahtar� b�rak�r ve baskas� gel�p bu thread � uyand�rana kadar bu thread cal�smaz. 
				
			} catch (InterruptedException e) {
			}
			System.out.println("Thread 1 uyand� devam ediyor . G�nayd�n ...:D");
		}
	
	public void thread2Fonk() {
		Scanner sc=new Scanner (System.in);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		} //burada thread� 2 n uyutuyoruz 
		//uyutmam�z�n neden� thread 1 2 sn boyunca anahtar� als�n d�ye 
	//	synchronized (this) 
		synchronized (lock) {
			
		}{
			System.out.println("Thread 2 �al�s�yor.");
			System.out.println("devam etmak i�in b�r tusa bas�n ");
			sc.nextLine();
			//i� bitti di�er thread � uyand�rmak i�in 
		    lock.notify();
			System.out.println("uyand� thread 1 ama ben blok u terkeden kadar bekleyecek y�ne ");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
	}
}
