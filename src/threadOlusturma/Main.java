package threadOlusturma;

public class Main {

	public static void main(String[] args) {
		//main method çalıştırıldığında otomatik olarak bir tane main method çalıştırılıyor.
		//olusturmasak bile bır tane thread kullanıyoruz
		
		
		System.out.println("Main Thread çalışıyor.");
		Printer p1=new Printer("p1");
		Printer p2=new Printer("p2");
		p2.start();  //bunların baslatılma suresi pc ye baglı
		System.out.println("//////////////////////////");
		p1.start();
		
		

	}

	

}
