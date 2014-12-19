class Productor extends Thread{
	private Cola cola;
	private String cadena;

	public Productor (Cola c){
		cola=c;
		this.cadena = "PING";
	}
	
	public void run(){
		while(true){
			
			cola.put(cadena);
		
			System.out.println(	"Productor: produce ->"+ cadena);
			
			if(this.cadena == "PING"){
				this.cadena = "PONG";
			} else {
				this.cadena = "PING";
			}
			
 			try {
				sleep(100);
			}catch (InterruptedException e){}
		}
	}
}
