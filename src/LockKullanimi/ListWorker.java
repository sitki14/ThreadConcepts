package LockKullanimi;

import java.util.ArrayList;
import java.util.Random;

public class ListWorker {
	Random rnd=new Random();
	ArrayList<Integer> list1=new ArrayList<Integer>();
	ArrayList<Integer> list2=new ArrayList<Integer>();
	
	//list 1 ve list ye 2000 deger atanacak main thread ile burada zaman ile performans kýyaslamasý yapýlacak.
	
	public void list1DegerEkle() {
		for(int i=0;i<2000;i++) {
			try {
				list1.add(i);
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		
	}
	public  void list2DegerEkle() {
		for(int i=0;i<2000;i++) {
			try {
				list2.add(i);
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		}
		
	}
	public void DegerAta() {
		list1DegerEkle();
		list2DegerEkle();
	}
	
	

}
