import java.io.*;
import java.net.*;
import java.util.Scanner;

class Cliente {
	//nombre  máquina y puerto
	static final String HOST = "localhost";
	static final int PUERTO = 5000;
	private Scanner lector = new Scanner(System.in);
	private Socket conexion;
	private String mensaje = "";
	private String respuesta = "";
	
	public Cliente( ) {

		try{

			//crear el socket
			this.conexion = new Socket(HOST, PUERTO);
		
		}catch(Exception e) {

		System.out.println( e.getMessage() );
		
		}
	}

	public void realizarConexion(){

		escritura("Hola",true);
		lectura(true);
	}

	public void interaccion(){
		try {
		
			while(true){

				//Visualizar Menu
				lectura(false);
				
				// Dar Orden
				mensaje = lector.nextLine();
				escritura(mensaje,false);

				if( mensaje.equalsIgnoreCase( "Fin" ) ) {
					// Recibir mensaje de Fin
					lectura(true);
					break;
				} else {
					// Recibir Respuesta
					lectura(false);
				}
			}
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}

	public String lectura(Boolean q) {

		try {

			InputStream input = this.conexion.getInputStream();
			DataInputStream dataInput = new DataInputStream( input );
			String mensaje = dataInput.readUTF();
			if(q){
				System.out.println("Servidor: " + mensaje);
			} else {
				System.out.print(mensaje);
			}
			
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
		return mensaje;
	}

	public void escritura( String mensaje, Boolean escrito ){

		try {
		
			OutputStream output = conexion.getOutputStream();
			DataOutputStream dataOutput = new DataOutputStream( output );
			dataOutput.writeUTF( mensaje );
			if(escrito) {
				System.out.println(mensaje);
			}
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}

	public static void main(String[] arg) {
		
		try {
				
			Cliente cliente = new Cliente();
			cliente.realizarConexion();
			cliente.interaccion();

			cliente.conexion.close();
			
		
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}
}
