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
    private Thread Hilo; 
    private int Incremento;
    
    
    public threadContador(long contador,int incremento){
        this.Contador = contador;
        this.Incremento = incremento;
    }
    
    public void run() {

        //recojo hiloActual
        this.Hilo=Thread.currentThread();
        while(true){
            try{
                this.Hilo.sleep(1000);
                this.Contador = this.Contador + this.Incremento;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
    public long getContador(){
        
        return this.Contador;
    }
    
}
