package threadOlusturma;

public class AnonimClass {

	public static void main(String[] args) {
	/*	
		 Thread anonimPrinter=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anoným class thread calýsýyoo");
			}
		});
		 */
new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anoným class thread calýsýyoo");
			}
		}).start(); //bu sekýlde de nesne adý vermeden tek seferlik threadý calýstýrabýlýrýz
		// anonimPrinter.start();
System.out.println("anomýn");
	}

}
