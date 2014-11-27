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
    private Contador appletContador;
    
    
    public threadContador(long contador,Contador applet){
        this.Contador = contador;
        this.appletContador = applet;
    }
    
    public void run() {

        //recojo hiloActual
        this.hilo=Thread.currentThread();
        while(true){
            try{
                this.hilo.sleep(1000);
                this.Contador++;
                this.appletContador.run();
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
