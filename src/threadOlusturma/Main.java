package threadOlusturma;

public class Main {

	public static void main(String[] args) {
		//main method çalýþtýrýldýðýnda otomatik olarak bir tane main method çalýþtýrýlýyor.
		//olusturmasak bile býr tane thread kullanýyoruz
		
		
		System.out.println("Main Thread çalýþýyor.");
		Printer p1=new Printer("p1");
		Printer p2=new Printer("p2");
		p2.start();  //bunlarýn baslatýlma suresi pc ye baglý
		System.out.println("//////////////////////////");
		p1.start();
		
		

	}

	

}
