package threadOlusturma;

import java.io.IOException;
import java.nio.CharBuffer;

public  class Printer2 implements Readable{//bu sekilde  de kullan�lab �l�r

	
		public void run() {
			System.out.println("selam ben runnable interface inin i�indeki run methodunun i�indeyim. ");
			
		}
	@Override
	public int read(CharBuffer arg0) throws IOException {
		return 0;
	}


	

}
