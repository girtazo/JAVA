public class Cola {
	//atributos
	private int numero;
	private boolean disponible=false;  // inicialmente vacia

	//metodos
	//sacar
	public int get(){
		if (disponible) { //si no esta vacia
			disponible=false; //pongo que esta vacia
			return numero; //devuelvo numero
		}	
		return -1; //no hay numero 
	}

	public void put(int valor){
		numero=valor; //colocar valor en la cola
		disponible=true; //disponible para consumir, cola llena
	}





}
