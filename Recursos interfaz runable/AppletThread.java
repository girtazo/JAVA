//librerias importo
import java.awt.*
import java.applet.*;

public class AppletThread extends Applet implements Runnable {

	//propiedades
	private Thread hilo=null;
	
	//método init
	public void init(){

	}

	public void start(){
		if (hilo==null){
				hilo=new Thread(this);	//creo el hilo
				hilo.start(); //lanzo hilo
			}
	}


	public void run(){
		Thread hiloActual=Thread.currentThread();
		while (hilo==hiloactual) //vble hilo apunta a hilo en ejecución
			{ 
			//Tarea repetitiva
			}
	}
	
	public void stop(){
		hilo=null;
	}
	
	public void paint(Graphics g){

	}

}
	

