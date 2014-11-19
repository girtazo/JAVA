public class HiloEjemplo2 extends Thread {

	//Metodo run
	public void run(){
	System.out.println ("Dentro del Hilo: " + this.getName() + "Prioridad: " + this.getPriority() + "ID: " + this.getId());
	}//fin run

	//Metodo main
	public static void main (String[] args){
	
	 HiloEjemplo2 h=null;
	
	for (int i=0;i<3; i++){
			h= new HiloEjemplo2(); //creo hilo

			h.setName ("HILO" + i); // establezo nombre
			h.setPriority (i+1); // establezco prioridad
			
			h.start(); // inicio hilo

			System.out.println ("Información del " + h.getName() + ": " + h.toString());			
		}
	System.out.println ("3 Hilos creados...");

	}//fin main

}//fin hilo
