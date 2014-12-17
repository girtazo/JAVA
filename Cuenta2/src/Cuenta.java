
public class Cuenta{
	
	private float maximo;
	private float saldo;
	
	public Cuenta(float max, float sald){
		
		this.maximo = max;
		this.saldo = sald;
		
	}
	
	public float getSaldo(){
		
		return saldo;
	}
	
	public synchronized void ingresar(float money , Persona persona  ){
		
		if(money+saldo < maximo){
			
			saldo = saldo + money;
			System.out.println(persona.name +" -> ha intentado ingresado "+money+" y su total de saldo en la cuenta es de"+saldo);
			
		} else {
			
			System.out.println(persona.name +" -> ha intentado ingresar "+money+" pero superaba el limite de saldo la cuenta de "+saldo);
		
		}
		
	}
	
	public synchronized void reintegro(float money , Persona persona  ){
		
		if(saldo-money >= 0){
			
			saldo = saldo - money;
			System.out.println(persona.name +" -> ha realizado un reintegro de "+money+" y su total de saldo en la cuenta es de" + saldo);
			
		} else {
			
			System.out.println(persona.name +" -> ha intentado realizar un reintegro de "+money+" pero no hay saldo suficiente su saldo es de "+saldo);
			
		}
		
	}
	
}
