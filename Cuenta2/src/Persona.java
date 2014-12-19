import java.util.Random;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;


public class Persona extends Thread{
	
	public String name;
	public Cuenta cuenta;
	
	public Persona ( String name, Cuenta cuenta ){
		
		this.name = name;
		this.cuenta = cuenta;
	}
	
	public void run(){
		Random random = new Random();
		while( true ){
			
			for(int c=0;c<2;c++){
				
				int money=random.nextInt(1001);
				cuenta.ingresar(money, this);
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int c=0;c<2;c++){
				
				int money=random.nextInt(1001);
				cuenta.reintegro(money, this);
				
				try {
					sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}
	
}
