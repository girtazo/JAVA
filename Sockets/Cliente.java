import java.io.*;
import java.net.*;

class Cliente {
	//nombre  máquina y puerto
	static final String HOST = "localhost";
	static final int PUERTO=5000;
	public Cliente( ) {
		try{
			//se crea el socket
			Socket skCliente = new Socket(HOST, PUERTO);

			//recojo flujo de datos del socket
			InputStream aux = skCliente.getInputStream();

			//asocio flujo de datos flujo de tipo DataInputStream
			DataInputStream flujo = new DataInputStream( aux );
			
			//Capturamos cadena del flujo con readUTF y muestro
			System.out.println( flujo.readUTF() );

			//Cierro el socket
			skCliente.close();
		}catch(Exception e) {
		System.out.println( e.getMessage() );
	}
	}
public static void main(String[] arg) {
new Cliente();
}
}
