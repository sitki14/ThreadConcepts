package threadOlusturma;

public class AnonimClass {

	public static void main(String[] args) {
	/*	
		 Thread anonimPrinter=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anon�m class thread cal�s�yoo");
			}
		});
		 */
new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("anon�m class thread cal�s�yoo");
			}
		}).start(); //bu sek�lde de nesne ad� vermeden tek seferlik thread� cal�st�rab�l�r�z
		// anonimPrinter.start();
System.out.println("anom�n");
	}

}
