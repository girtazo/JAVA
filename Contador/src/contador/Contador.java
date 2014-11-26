package contador;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Contador extends Applet implements Runnable, ActionListener {

    //Propiedades
    private Thread hilo;
    private Thread hilo2;
    private Font fuente;
    long CONTADOR1=1;
    long CONTADOR2=3;
    private boolean parar;
    private Button b1,b2; //botones del Applet


    public void start(){
        
    }	

    //método init
    public void init(){
        System.out.println("init");
        setBackground(Color.yellow);//color de fondo

        //añado botón 1 y su listener
        add(b1=new Button("Finalizar hilo 1"));
        b1.addActionListener(this);
        
        
        //añado botón 2 y su listener
        add(b2=new Button("Finalizar hilo 2"));
        b2.addActionListener(this);

        fuente=new Font("Verdana",Font.BOLD,26); //tipo de letra
        hilo = new Thread();
        hilo2 = new Thread();
    }


    public void run() {
        System.out.println("run");
        //inicializo parar a falso
        parar=false;

        //recojo hiloActual
        Thread hiloActual=Thread.currentThread();

        while (hilo==hiloActual && !parar){
                try{
                    Thread.sleep(300);
                }catch (InterruptedException e){e.printStackTrace();}
                repaint();
                CONTADOR1++;
        }//fin while
        while (hilo2==hiloActual && !parar){
                try{
                   Thread.sleep(300);
                }catch (InterruptedException e){e.printStackTrace();}
                repaint();
                CONTADOR2++;
        }

    }//fin run


    public void paint(Graphics g){
        System.out.println("paint");
        g.setFont(fuente);
        g.drawString("HILO 1: "+Long.toString((long)CONTADOR1),80,100);
        g.drawString("HILO 2: "+Long.toString((long)CONTADOR2),80,150);
        

    }


    //parar controlar pulsación botones	
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1){//comienzo
            if (hilo.isAlive()){
                hilo = null;
                //si el hilo está corriendo y vivo no hago nada
            }
        }
        if (e.getSource()==b2){ //parada
            if (hilo2.isAlive()){
                hilo2 = null;
                //si el hilo está corriendo y vivo no hago nada
            }
        }
        

    }//actionperformed
}

