/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem1_productor_consumidor;

/**
 *
 * @author mati
 */
class Consumidor extends Thread {
	private Cola cola;
	private int n;

	public Consumidor (Cola c, int n){
		cola=c;
		this.n=n;
	}
	
	public void run(){
		int valor=0;
		for (int i=0;i<5;i++){
			valor=cola.get();//recoge el numero
			System.out.println(i+"->Consumidor:"+ n + ", consume: "+valor);
	 			
		}
	}

}
