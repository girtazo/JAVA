 class Hilointerrupt extends Thread{

	public void run(){
		
		try {
			while (!isInterrupted()){
				System.out.println("En el hilo");
				Thread.sleep(10);
			}
		}catch (InterruptedException e){
			System.out.println("Ha ocurrido una excepcion");
		}
		
	System.out.println("Fin hilo");		
	}//fin run
	
	
 public void interrumpir(){
	 interrupt();
 }
 
 public static void main (String[] args){
	 Hilointerrupt h=new Hilointerrupt();
	 h.start();
	 
	 for (int i=0;i<10000000;i++);//no hago nada
		 h.interrumpir();
	 
	 
}
	 
 }
