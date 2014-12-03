/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moverpelota;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Pelota extends Thread{
    
    public int altura = 50;
    public int anchura = 50;
    public int x;
    public int y;
    public String direccion;
    private Campo campo;
    private boolean libre;
    
    public Pelota(int x,int y,int anchura, int altura,Campo campo){
        this.x = x;
        this.y = y;
        this.anchura = anchura;
        this.altura = altura;
        this.campo = campo;
        this.libre = true;
    }
    
    public void run(){
        try {
            while(true){
                
                while(libre){
                
                    sleep(10);
                    if(campo.getLimitex()[1]>this.x){
                        moverDerecha();
                    } else {
                        libre = false;
                    }
                
                }
                libre = true;
                while(libre){
                    sleep(10);
                    if(campo.getLimitex()[0]<this.x){
                        moverIzquierda();
                    } else {
                        libre = false;
                    }
                }
                libre = true;
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Pelota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void moverDerecha(){
            x = x+1;
    }
    
    public int getx(){
    return x;
    }
    
    public void moverIzquierda() throws InterruptedException{
            x = x-1;
    }
}
