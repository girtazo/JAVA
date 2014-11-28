package contador;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Contador extends Applet implements Runnable{

    //Propiedades
    private threadContador hilo;
    private threadContador hilo2;
    private threadContador hilo3;
    private long contador1;
    private long contador2;
    private long contador3;
    private Font fuente;
    private boolean run;

    //método init
    public void init(){
        
        setBackground(Color.yellow);

        fuente=new Font("Verdana",Font.BOLD,26);
        
        this.run = false;
        
    }
    public void start(){
        this.hilo = new threadContador(1,1);
        this.hilo2 = new threadContador(5,3);
        this.hilo3 = new threadContador(10,3);
        this.hilo.start();
        this.hilo2.start();
        
    }
    public void run(){
        long contador1;
       //contador = this.hilo.getContador();
         // contador = this.hilo2.getContador();
           //contador = this.hilo3.getContador();
        System.out.println("entra");
        contador1=3;
        while(true){
            repaint();
        }
        
    }
    public void paint(Graphics g){
        g.setFont(fuente);
        String cadena;
     
       
        cadena= "Hilo1: "+contador1;
     
        cadena += " Hilo2: "+contador1;
       
        cadena += " Hilo3: "+contador1;
        g.drawString(cadena,80,100);
        if(!this.run){
            this.run = false;
            this.run();
        }
    }
}

