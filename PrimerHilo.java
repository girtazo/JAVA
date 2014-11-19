
//clase PrimerHilo
public class PrimerHilo extends Thread {

	//propiedades clase
	private int x;
	
	//constructor clase
	PrimerHilo(int x)
	{
		this.x=x;
	}
		//método ejecución run
		public void run(){
			//acciones que lleva a cabo el hilo
			for (int i=0;i<x;i++)
				System.out.println("En el hilo..");
		}

	//Método main
	public static void main(String[] args){
	
	PrimerHilo p=new PrimerHilo(10);//creo hilo
	p.start();//iniciar hilo
	
	
	} //fin main
}
