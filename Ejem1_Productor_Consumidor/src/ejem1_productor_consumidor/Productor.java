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
class Productor extends Thread{
	private Cola cola;
	private int n;

	public Productor (Cola c,int n){
		cola=c;
		this.n=n;
	}
	
	public void run(){
		for (int i=0;i<5;i++){
			cola.put(i); //pone el número
			System.out.println(i	+"->Productor:"+ n + ", produce: "+i);
 			try {
				sleep(100);
			}catch (InterruptedException e){}
		}
        }
}
	
