package LockKullanimi;

public class Main {

	public static void main(String[] args) {
		ListWorker lw=new ListWorker();
		
		long baslangic=System.currentTimeMillis(); 
		lw.DegerAta();
		long bitis =System.currentTimeMillis();
		System.out.println("gecen süre: "+(bitis-baslangic));
		

	}

}
