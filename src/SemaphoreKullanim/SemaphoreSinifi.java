package SemaphoreKullanim;

import java.util.concurrent.Semaphore;

public class SemaphoreSinifi {
	private Semaphore sem=new Semaphore(3);
	public void ThreadKullanimi(int id) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			sem.acquire();
			
		} catch (InterruptedException e) {
		}
		System.out.println("Thread �al���yor id numaras�:"+id);
		sem.release();
	}

}
