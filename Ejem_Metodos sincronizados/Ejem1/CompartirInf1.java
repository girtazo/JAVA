public class CompartirInf1{
	public static void main (String[] args){
		Contador cont=new Contador(100); //creo contador valor inicial 100
		HiloA a=new HiloA("HiloA",cont); //creo hiloA (incrementa) y le paso contador
		HiloB b=new HiloB("HiloB",cont); //creo hiloB (decerementa) y le paso contador
		a.start(); //inicio hiloA
		b.start(); //inicio hiloB
			
	}


}
