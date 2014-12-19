
public class Cuenta{
	
	private int maximo;
	private int saldo;
	
	public Cuenta(int max, int sald){
		
		this.maximo = max;
		this.saldo = sald;
		
	}
	
	public float getSaldo(){
		
		return saldo;
	}
	
	public synchronized void ingresar(int money , Persona persona  ){
		
		if(money+saldo < maximo){
			
			saldo = saldo + money;
			System.out.println( persona.name + " -> ha intentado ingresado "+money+" y su total de saldo en la cuenta es de "+saldo);
			
		} else {
			
			System.out.println( persona.name + " -> ha intentado ingresar "+money+" pero superaba el limite de saldo la cuenta de "+saldo);
		
		}
		
	}
	
	public synchronized void reintegro(int money , Persona persona ){
		
		if(saldo-money >= 0){
			
			saldo = saldo - money;
			System.out.println(persona.name +" -> ha realizado un reintegro de "+money+" y su total de saldo en la cuenta es de " + saldo);
			
		} else {
			
			System.out.println(persona.name +" -> ha intentado realizar un reintegro de "+money+" pero no hay saldo suficiente su saldo es de "+saldo);
			
		}
		
	}
	
}
