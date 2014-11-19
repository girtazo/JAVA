import java.lang.*;
public class UsaHilo_toString {
  public static void main(String[] args){
		HiloEjemplo_Alive h=null;
		h=new HiloEjemplo_Alive(1); //creo hilo

	        h.start(); //iniciar hilo
        
		System.out.println ("Información Id hilo= " + h.getId());
		 System.out.println ("Información  hilo= " + h.toString());
	 } //fin main

	
} //clase usa hilo
