public class UsaPrimerHiloR{
	public static void main (String[] args){
		PrimerHiloR p=new PrimerHiloR(10); //creo objeto hilo
		new Thread(p).start(); //inicio ejecución
		}


}
