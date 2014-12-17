package cuenta;
class Cuenta{
	private int saldo;

	//constructor
	Cuenta (int s)
	{
		saldo=s; //inicializa el saldo actual
	}//--------------------------------------
	
	//devuelve el saldo
	int getSaldo()
	{
		return saldo; //devuelve el saldo
	}//--------------------------------

	// resta la cantidad al saldo
	void restar(int cantidad)
	{
		saldo=saldo-cantidad;
	}//-----------------------------------


	//comprueba se pueda retirar dinero  y lo retira
	synchronized void RetirarDinero(int cant,String nom)
	{
		if (getSaldo()>=cant){
			System.out.println ("Se va a retirar saldo (actual es: "+ getSaldo() +")");
			try {
				Thread.sleep(500);
				} catch (InterruptedException ex) {}
			restar (cant);
			System.out.println (nom +" retira => : "+cant +". Saldo Actual: "+ getSaldo() +"");
		}
		else{
			System.out.println (nom +" No puede retirar dinero no hay saldo. Saldo Actual: "+ getSaldo() +"");
		}	
		
	}// fin retirar dinero------------------------------

	
}//Cuenta
