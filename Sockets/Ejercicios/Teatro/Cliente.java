import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {
	//nombre  máquina y puerto
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	private Scanner lector = new Scanner(System.in);
	public Cliente( ) {

		try{

			String mensaje;

			//crear el socket
			Socket skCliente = new Socket(HOST, PUERTO);
			

			//asocio flujo salida de datos al socket
			OutputStream Outaux = skCliente.getOutputStream();
				
			//asocio flujo de datos flujo de tipo DataOutputStream 
			DataOutputStream Outflujo = new DataOutputStream( Outaux );

			Outflujo.writeUTF( lector.nextLine() );
			//recojo flujo de datos del socket
			InputStream Inaux = skCliente.getInputStream();

			//asocio flujo de datos flujo de tipo DataInputStream
			DataInputStream Influjo = new DataInputStream( Inaux );
			
			//Capturamos cadena del flujo con readUTF y muestro
			System.out.println( Influjo.readUTF() );

			while(true){

				mensaje = scan.nextLine();

				//asocio flujo salida de datos al socket
				Outaux = skCliente.getOutputStream();
				
				//asocio flujo de datos flujo de tipo DataOutputStream 
				Outflujo = new DataOutputStream( Outaux );
			
				Outflujo.writeUTF( mensaje );

				if( mensaje.equalsIgnoreCase( "Adios" ) ) {

					Inaux = skCliente.getInputStream();

					//asocio flujo de datos flujo de tipo DataInputStream
					Influjo = new DataInputStream( Inaux );
			
					//Capturamos cadena del flujo con readUTF y muestro
					System.out.println( Influjo.readUTF() );
					break;

				}
				Inaux = skCliente.getInputStream();

				//asocio flujo de datos flujo de tipo DataInputStream
				Influjo = new DataInputStream( Inaux );
			
				//Capturamos cadena del flujo con readUTF y muestro
				System.out.println( Influjo.readUTF() );

			}
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
