class Consumidor extends Thread {
	private Cola cola;
	private String cadena;

	public Consumidor (Cola c){
		this.cola=c;
	}
	
	public void run(){
		while(true){
			cadena=this.cola.get();
			System.out.println("Consumidor: consume->"+ cadena);
		}
	}

}
