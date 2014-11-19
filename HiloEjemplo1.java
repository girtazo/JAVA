public class HiloEjemplo1 extends Thread {
	//Propiedades --------------------------------
	private int c; //contador hilo
	private int hilo;

	//Constructor --------------------------------
	public HiloEjemplo1 (int hilo){
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
	//Método main
	public static void main(String[] args){
	HiloEjemplo1 h=null;
	for (int i=0;i<3;i++){
		h=new HiloEjemplo1(i+1); //creo hilo
		h.start(); //iniciar hilo
		}		
	System.out.println("3 Hilos creados...");
	} //fin main

} //fin clase
