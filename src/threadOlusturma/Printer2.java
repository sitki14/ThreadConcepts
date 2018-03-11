package threadOlusturma;

import java.io.IOException;
import java.nio.CharBuffer;

public  class Printer2 implements Readable{//bu sekilde  de kullanýlab ýlýr

	
		public void run() {
			System.out.println("selam ben runnable interface inin içindeki run methodunun içindeyim. ");
			
		}
	@Override
	public int read(CharBuffer arg0) throws IOException {
		return 0;
	}


	

}
