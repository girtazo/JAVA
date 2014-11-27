package contador;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Contador extends Applet implements Runnable, ActionListener{

    //Propiedades
    private threadContador hilo;
    private threadContador hilo2;
    private Font fuente;
    long CONTADOR1=1;
    long CONTADOR2=3;
    private boolean parar;
    private Button b1,b2;
    private boolean run;

    //método init
    public void init(){
        
        setBackground(Color.yellow);

        //añado botón 1 y su listener
        add(b1=new Button("Finalizar hilo 1"));
        b1.addActionListener(this);
        
        //añado botón 2 y su listener
        add(b2=new Button("Finalizar hilo 2"));
        b2.addActionListener(this);

        fuente=new Font("Verdana",Font.BOLD,26);
        
        this.parar = false;
        this.run = false;
        
    }
    public void start(){
        this.hilo = new threadContador(this.CONTADOR1,this);
        this.hilo2 = new threadContador(this.CONTADOR2,this);
        this.hilo.start();
        this.hilo2.start();
        
    }
    public void run(){
        if(this.hilo != null){
            this.CONTADOR1 = this.hilo.getContador();
        }
        if(this.hilo2 != null){
            this.CONTADOR2 = this.hilo2.getContador();
        }
        repaint();
    }
    
    public void paint(Graphics g){
        
        g.drawString("HILO 1: "+Long.toString((long)this.CONTADOR1),80,100);
        g.drawString("HILO 2: "+Long.toString((long)this.CONTADOR2),80,150);
        
        g.setFont(fuente);
        
    }


    //parar controlar pulsación botones	
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){//comienzo
            if (hilo.isAlive()){
                this.hilo.stop();
                this.b1.setLabel("Finalizado 1");
                
            }
        }
        if (e.getSource()==b2){ //parada
            if (hilo2.isAlive()){
                this.hilo2.stop();
                this.b2.setLabel("Finalizado 2");
                //si el hilo está corriendo y vivo no hago nada
            }
        }
        

    }//actionperformed
}

