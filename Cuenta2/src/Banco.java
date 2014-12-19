
public class Banco {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Cuenta cuenta = new Cuenta(1000000,10000);
		
		Persona persona1 = new Persona("Juan",cuenta);
		Persona persona2 = new Persona("David",cuenta);
		
		persona1.start();
		persona1.sleep(1500);
		persona2.start();
	}

}
