package threadOlusturma;

public class Main {

	public static void main(String[] args) {
		//main method �al��t�r�ld���nda otomatik olarak bir tane main method �al��t�r�l�yor.
		//olusturmasak bile b�r tane thread kullan�yoruz
		
		
		System.out.println("Main Thread �al���yor.");
		Printer p1=new Printer("p1");
		Printer p2=new Printer("p2");
		p2.start();  //bunlar�n baslat�lma suresi pc ye bagl�
		System.out.println("//////////////////////////");
		p1.start();
		
		

	}

	

}
