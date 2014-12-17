package cuenta;

import java.util.logging.Level;
import java.util.logging.Logger;

class SacarDinero extends Thread{
	private Cuenta c; //declaro objeto cuenta c
	String nom;
	
	//constructor
	public SacarDinero (String n, Cuenta c){
		super(n);
		this.c=c;
	}
	//run
	public void run(){
		for (int x=1;x<=4;x++){
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SacarDinero.class.getName()).log(Level.SEVERE, null, ex);
                    }
			c.RetirarDinero(10,getName());
		}
	}

}
