class HiloA extends Thread{
	private Contador contador;
	
	public HiloA(String n,Contador c){
		setName(n);
		contador=c;
	}
	
	public void run(){
		synchronized (contador) {
		for (int j=0;j<300;j++)
			{
			contador.incrementa();//incrementa el contador
			}
		System.out.println( getName() + " contador vale " + contador.getValor());
		}
	}
}//FIN HILOA
