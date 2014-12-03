/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moverpelota;

/**
 *
 * @author mati
 */
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Campo extends Applet implements Runnable{

    //Propiedades
    private Pelota pelota;
    private Font fuente;
    private long [] limitex   = new long[2];
    private Thread campo = null;
    

    //método init
    public void init(){
        
        setBackground(Color.white);
        limitex[0] = 0;
        limitex[1] = 300;
        pelota = new Pelota(50,50,50,50,this);
        
        
        
    }
    public void start(){
        
        
        if(campo == null){
            campo = new Thread(this);
            campo.start();
        }
        
    }
    public void run(){
        while(campo == Thread.currentThread()){
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Campo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(pelota.movimiento == "derecha"){
                if(limitex[1]>pelota.x){
                    pelota.moverDerecha();
                } else {
                    pelota.movimiento = "izquierda";
                }
            } else {
                if(limitex[0]<pelota.x){
                    pelota.moverIzquierda();
                } else {
                    pelota.movimiento = "derecha";
                }
            }
            
            repaint();
        }
    }
    public long [] getLimitex(){
        return this.limitex;
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillArc(pelota.x ,pelota.y, pelota.anchura, pelota.altura, 0, 360);
    }
}
