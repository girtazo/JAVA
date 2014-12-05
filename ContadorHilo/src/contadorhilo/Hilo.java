package contadorhilo;

public class Hilo extends Thread{

	//propiedades
	private int contador;
	
	//me declaro vble utilizare de flag 
	private volatile boolean stopRequested = false; //volatile pueden acceder a ella varios hilos
	
	//constructor
	Hilo (int x){
		this.contador=x;
	}
	
	
	
	//run	
	public void run(){
		try {
			while ((!stopRequested)) {
				contador++;
				Thread.sleep(1000);
			}
		}catch (InterruptedException e){
			System.out.println("Ha ocurrido una excepcion");
		}
				
	}
	
	public void requestStop() {
		  stopRequested = true;
		}
	
	public int getcontador(){
		return contador;
	}
		
}
