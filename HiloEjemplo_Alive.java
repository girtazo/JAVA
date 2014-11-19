public class HiloEjemplo_Alive extends Thread {
	
	//Propiedades --------------------------------
	private int c; //contador hilo
	private int hilo;

	//Constructor --------------------------------
	public HiloEjemplo_Alive (int hilo){
		this.hilo=hilo;
		System.out.println("Creando Hilo: " + hilo);
	}//fin constructor
	
	//Método Run -----------------------------------
	public void run(){
		c=0;
		while (c<=5){
			System.out.println ("Hilo:"+ hilo + " C= " + c);
			c++;
		}
	}//fin run
	
} //fin clase
