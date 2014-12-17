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
public class Ejem1_Productor_Consumidor{
	public static void main(String[] args) {
		Cola cola=new Cola();
		Productor p=new Productor(cola,1);
		Consumidor c=new Consumidor(cola,1);
		p.start();
		c.start();	
		
	}
	


}
