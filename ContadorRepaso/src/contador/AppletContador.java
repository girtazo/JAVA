package contador;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AppletContador extends Applet{

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
        this.hilo = new threadContador(1,1,this);
        this.hilo2 = new threadContador(5,3,this);
        this.hilo3 = new threadContador(10,3,this);
        this.hilo.start();
        this.hilo2.start();
        this.hilo3.start();
        
    }
    public void run(){
        repaint();
    }
    public void paint(Graphics g){
        g.setFont(fuente);
        String cadena;

        cadena= "Hilo1: "+this.hilo.getContador();
        cadena += " Hilo2: "+this.hilo2.getContador();
        cadena += " Hilo3: "+this.hilo3.getContador();
        g.drawString(cadena,80,100);
    }
}

