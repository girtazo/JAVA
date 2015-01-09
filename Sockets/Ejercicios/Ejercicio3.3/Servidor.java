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
				//asocio flujo salida de datos al socket
				OutputStream aux = skCliente.getOutputStream();
				//asocio flujo de datos flujo de tipo DataOutputStream 
				DataOutputStream flujo= new DataOutputStream( aux );
				//escribo
				flujo.writeUTF( "He recibido" );
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
