import java.lang.*;
public class UsaHilo_Alive {
  public static void main(String[] args){
		HiloEjemplo_Alive h=null;
		h=new HiloEjemplo_Alive(1); //creo hilo

		//Compruebo estado antes llamar a start
	     System.out.println("Antes llamada a start");
	     System.out.println("Is Alive? = " + h.isAlive());
		 System.out.println("State:" + h.getState());

	    System.out.println("llamo a start");
		h.start(); //iniciar hilo
    	
		//Compruebo estado tras llamar a start
		System.out.println("State:" + h.getState());
	    System.out.println("Is Alive? = " + h.isAlive());
	
	 // llamo a join y espero termine	
	 try{
                h.join();
            } catch (Exception ex){}

	// Compruebo estado tras finalizar hilo
	System.out.println("Tras finalizar hilo ");
	System.out.println("State:" + h.getState());
	    System.out.println("Is Alive? = " + h.isAlive());
	} //fin main
} //clase usa hilo
