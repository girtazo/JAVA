class HiloB extends Thread{
	private Contador contador;
	
	public HiloB(String n,Contador c){
		setName(n);
		contador=c;
	}
	
	public void run(){
		for (int j=0;j<300;j++)
			{
			contador.decrementa();//decrementa el contador
			try {
				sleep(100);
			}catch (InterruptedException e) {}
			}
		System.out.println(getName() + " contador vale " + contador.getValor());
		}

}//FIN HILOB
