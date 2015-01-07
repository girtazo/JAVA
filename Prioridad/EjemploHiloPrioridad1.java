class EjemploHiloPrioridad1 {

	public static void main (String args[]) {
		
		//Creo objetos hilos
			HiloPrioridad1 h1=new HiloPrioridad1();
			HiloPrioridad1 h2=new HiloPrioridad1();
			HiloPrioridad1 h3=new HiloPrioridad1();
	
		//Establezco prioridades
			h1.setPriority(Thread.NORM_PRIORITY);
			h2.setPriority(Thread.MAX_PRIORITY);
			h3.setPriority(Thread.MIN_PRIORITY);

		//Inicio hilos
			h1.start();
			h2.start();
			h3.start();

		try {
			Thread.sleep(5000);
			} catch (Exception e) {}
			

		//Paro hilos hilos
			h1.pararHilo();
			h2.pararHilo();
			h3.pararHilo();

	System.out.println("h2 (Prioridad Maxima): " + h2.getContador());
	System.out.println("h1 (Prioridad Normal): " + h1.getContador());
	System.out.println("h3 (Prioridad Minima): " + h3.getContador());
	}
}
