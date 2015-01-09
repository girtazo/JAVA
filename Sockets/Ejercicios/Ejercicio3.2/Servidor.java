import java.io.* ;
import java.net.* ;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"
class Servidor {

//puerto espera conexiones
static final int PUERTO=5000;

	public Servidor( ) {

		try {
			//crea socket y espera
			ServerSocket skServidor = new ServerSocket( PUERTO );
			System.out.println("Escucho el puerto " + PUERTO );

			while (true){
				//Primitiva accept() crea nuevo socket skCliente
				//skCliente atiene al cliente
				Socket skCliente = skServidor.accept(); // Crea objeto

				System.out.println("Esperando peticiones " );

				InputStream aux = skCliente.getInputStream();

				//asocio flujo de datos flujo de tipo DataInputStream
				DataInputStream flujo = new DataInputStream( aux );
			
				//Capturamos cadena del flujo con readUTF y muestro
				System.out.println( flujo.readUTF() );

				//asocio flujo salida de datos al socket
				OutputStream auxE = skCliente.getOutputStream();
				//asocio flujo de datos flujo de tipo DataOutputStream 
				DataOutputStream flujoE = new DataOutputStream( auxE );
				
				//escribo
				flujoE.writeUTF( "Hola Cliente" );

				aux = skCliente.getInputStream();

				//asocio flujo de datos flujo de tipo DataInputStream
				flujo = new DataInputStream( aux );
			
				//Capturamos cadena del flujo con readUTF y muestro
				System.out.println( flujo.readUTF() );

				//asocio flujo salida de datos al socket
				auxE = skCliente.getOutputStream();
				//asocio flujo de datos flujo de tipo DataOutputStream 
				flujoE = new DataOutputStream( auxE );

				flujoE.writeUTF( "Adios Cliente" );
				
				System.out.println("Esperando peticiones " );
				
				//cierro conexión
				skCliente.close();
			}//fin for

		} catch( Exception e ) {

			System.out.println( e.getMessage() );

		}

}

public static void main( String[] arg ) {

new Servidor();

}

}
