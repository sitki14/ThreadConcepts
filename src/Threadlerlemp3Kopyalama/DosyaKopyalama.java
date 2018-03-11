package Threadlerlemp3Kopyalama;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class DosyaKopyalama {
	private static ArrayList<Integer> icerik=new ArrayList<Integer>();
	
	public static void DosyaOku() {
		try {
			FileInputStream in=new FileInputStream("Threadmars.mp3");
			
			// burada dosyayý okuma iþlemi yapýlýr.
			
			int oku;
			while ((oku=in.read())!=-1) {
				icerik.add(oku);
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	
	//yený bir method olusturarak kopya almayý saglayacagýz.
	public static void Kopyala(String dosyaismi) {
		try {
			FileOutputStream out=new FileOutputStream(dosyaismi);
			for(int deger:icerik) {
				out.write(deger);
			}
			
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		
	}
 
	
	
	//hesapalama
	public static void main(String[] args) {
	
		System.out.println("hedef 1");
		long baslanic=System.currentTimeMillis();
		DosyaOku();
		long orta=System.currentTimeMillis();
		System.out.println("hedef 2");
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Kopyala("ThreadkopyaDosya0.mp3");
			}
		});
		
		long sonDuzluk =System.currentTimeMillis();
		Thread t2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Kopyala("ThreadkopyaDosya1.mp3");
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		long bitis=System.currentTimeMillis();
		
		System.out.println("kopyalandý");
		System.out.println("Dosya okuma iþlemi: "+(orta-baslanic)/1000 +"sn sürdü.");
		System.out.println("Dosya0 kopyalama iþlemi: "+(sonDuzluk-orta)/1000+"sn sürdü.");
		System.out.println("Dosya1 kopyalama iþlemi: "+(bitis-sonDuzluk)/1000+"sn sürdü.");
		System.out.println("tüm iþlemler :" +(bitis-baslanic)/1000 +"sn sürdü.");
		//thread kullanarak bu sanýyeyý dusurmeye calýsacaýz 
		// sýmdý bu iþlemler ortalama 46 47 48 sanýye suruyo 
		//thread kullanarak 36 saniye ye düþürdük
		

	}

}
