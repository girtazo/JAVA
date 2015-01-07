class EjemploHiloPrioridad2 {

	public static void main (String args[]) {
		
		//Creo objetos hilos
			HiloPrioridad2 h1=new HiloPrioridad2("Uno");
			HiloPrioridad2 h2=new HiloPrioridad2("Dos");
			HiloPrioridad2 h3=new HiloPrioridad2("Tres");
			HiloPrioridad2 h4=new HiloPrioridad2("Cuatro");
			HiloPrioridad2 h5=new HiloPrioridad2("Cinco");
	
		//Establezco prioridades
			h1.setPriority(Thread.MIN_PRIORITY);
			h2.setPriority(3);
			h3.setPriority(Thread.NORM_PRIORITY);
			h4.setPriority(7);
			h5.setPriority(Thread.MAX_PRIORITY);

		//Ejecuto hilos
			h1.start();
			h2.start();
			h3.start();
			h4.start();
			h5.start();		
	}
}
