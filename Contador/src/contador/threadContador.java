/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contador;

/**
 *
 * @author david
 */
public class threadContador extends Thread {
    
    private long Contador;
    private Thread hilo; 
    
    
    public threadContador(long contador){
        this.Contador = contador;
    }
    
    public void run() {

        //recojo hiloActual
        this.hilo=Thread.currentThread();
        while(true){
            try{
                this.hilo.sleep(1000);
                this.Contador++;
                System.out.println(this.Contador);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public long getContador(){
        
        return this.Contador;
    }
    
}
