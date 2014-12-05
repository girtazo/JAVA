package contadorhilo;

//Librerias importo
import java.awt.*;
import java.applet.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;




public class Reloj extends Applet implements Runnable,ActionListener {

	//propiedades
	private Thread hilo_applet=null; //hilo clase Thread
	private Hilo h1=null;
	int contador_applet=0;
	private Button b1,b2; //botones del Applet
	
	private Font fuente;  //tipo de letra de la hora
	//private String horaActual="";


//m�todo init
public void init(){
	fuente=new Font("Verdana",Font.BOLD,26);
	//a�ado bot�n 1 y su listener
	add(b1=new Button("Finalizar hilo contador"));
	b1.addActionListener(this);
}

public void start(){
	if (hilo_applet==null){
		hilo_applet=new Thread(this);	//creo el hilo
		hilo_applet.start(); //lanzo hilo
		}
	
		h1=new Hilo(4);	//creo el hilo
		h1.start(); //lanzo hilo
	
}


public void run(){
	Thread hiloActual=Thread.currentThread();

	while (hilo_applet==hiloActual) //vble hilo apunta a hilo en ejecuci�n
		{ 
			//actualizo contador_applet
			//SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			//Calendar cal=Calendar.getInstance();
			//horaActual=sdf.format(cal.getTime());
			
			repaint(); //actualiza contenido applet
			
			//espero un segundo
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e){}
		}
}

public void stop(){
	hilo_applet=null;
}

public void paint(Graphics g){
	contador_applet=h1.getcontador();
	g.clearRect(1,1, getSize().width,getSize().height);
	setBackground(Color.white); //color de fondo
	g.setFont (fuente); //fuente
	g.drawString( Integer.toString(contador_applet),30,150); // muestra la hora
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	if (arg0.getSource()==b1){//paro hilo1
		b1.setLabel("Finalizado hilo1");
		h1.requestStop();
	}	
}

}
