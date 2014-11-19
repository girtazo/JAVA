public class UsaHiloEjemplo1_V2 {
  public static void main(String[] args){
		HiloEjemplo1_V2 h=null;
		for (int i=0;i<3;i++){
		h=new HiloEjemplo1_V2(i+1); //creo hilo
		h.start(); //iniciar hilo
     // tests if this thread is alive
      System.out.println("status = " + h.isAlive());
		}		
	System.out.println("3 Hilos creados...");
	} //fin main
} //clase usa hilo
