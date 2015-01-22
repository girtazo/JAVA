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

		escritura("Hola");
		lectura();
	}

	public void interaccion(){
		try {
		
			while(true){

				mensaje = lector.nextLine();

				escritura(mensaje);
				respuesta = lectura();

				if( mensaje.equalsIgnoreCase( "Fin" ) ) {

					conexion.close();
					break;

				}
			}
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}
	public String lectura() {

		try {

			InputStream input = this.conexion.getInputStream();
			DataInputStream dataInput = new DataInputStream( input );
			mensaje = dataInput.readUTF();
			System.out.println("Servidor: " + mensaje);
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
		return mensaje;
	}

	public void escritura( String mensaje ){

		try {
		
			OutputStream output = conexion.getOutputStream();
			DataOutputStream dataOutput = new DataOutputStream( output );
			dataOutput.writeUTF( mensaje );
			System.out.println(mensaje);
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}

	public static void main(String[] arg) {
		
		Cliente cliente = new Cliente();
		cliente.realizarConexion();
		cliente.interaccion();
	}
}
