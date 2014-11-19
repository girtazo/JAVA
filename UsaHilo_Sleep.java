
public class UsaHilo_Sleep {
  public static void main(String[] args){
		HiloEjemplo_Alive h=null;
		h=new HiloEjemplo_Alive(1); //creo hilo
		h.start(); //iniciar hilo
    	
		try {		
		// Pause for 4 seconds
         h.sleep(4000);
			 } catch (InterruptedException e) {
                          }
	
	} //fin main
} //clase usa hilo
