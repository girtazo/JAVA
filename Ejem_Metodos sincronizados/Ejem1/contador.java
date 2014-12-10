class Contador {

	private int c=0; //atributo contador

	//constructor	
	Contador (int c) {
		this.c=c;
	}

	public void incrementa(){
		c=c+1;	
		}

	public void decrementa(){	
		c=c-1;	
		}
	public int getValor(){
		return c;	
		}
	
}//CONTADOR
