package Reentrant_Lock;

import java.sql.Ref;

public class Main {

	public static void main(String[] args) {
		Reentrant_Lock RefNesne=new Reentrant_Lock();
		Thread t1=new Thread(new Runnable() {
		
			@Override
			public void run() {
				RefNesne.thread1Fonk();
				
			}
		});
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				RefNesne.thread2Fonk();
				
			}
		});
		t1.start();
		t2.start();
	
		try {
			t2.join();
			t1.join();
		} catch (InterruptedException e) {
		}
		RefNesne.threadOver();


	}

}
