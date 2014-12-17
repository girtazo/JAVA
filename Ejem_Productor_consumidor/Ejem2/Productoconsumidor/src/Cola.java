public class Cola {
	//atributos
	private int numero;
	private boolean disponible=false;  // inicialmente vacia

	//metodos
	//sacar
	public synchronized int get(){
		while (disponible==false) { //si esta vacia
			try {
				wait();
			}catch (InterruptedException e){};
		
		}	
		disponible=false;
		notifyAll();
		return numero; //no hay numero 
	}

	public synchronized void put(int valor){
		while (disponible==true) { //si no esta vacia
			try {
				wait();
			}catch (InterruptedException e){};
		
		}
		numero=valor;
		disponible=true;
		notifyAll();
		
	}





}
