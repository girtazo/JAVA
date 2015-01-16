import java.io.* ;
import java.net.* ;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"
class Servidor {

//puerto espera conexiones
static final int PUERTO=5000;
String[] mensajes = new String[5];

	public Servidor( ) {

		try {
			mensajes[0] = "Esperando conexión...";
			mensajes[1] = "Conectado.";
			mensajes[2] = "Hola, soy el servidor.";
			mensajes[3] = "Muy bien.";
			mensajes[4] =  "Hasta luego";
			
			//crea socket y espera
			ServerSocket skServidor = new ServerSocket( PUERTO );
			System.out.println(mensajes[0]);
			Socket skCliente = skServidor.accept();
			System.out.println( mensajes[1] );

			//recojo flujo de datos del socket
			InputStream in_aux = skCliente.getInputStream();

			//asocio flujo de datos flujo de tipo DataInputStream
			DataInputStream in_flujo = new DataInputStream( in_aux );

			System.out.println( in_flujo.readUTF() );
			
			//asocio flujo salida de datos al socket
			OutputStream out_aux = skCliente.getOutputStream();
				
			//asocio flujo de datos flujo de tipo DataOutputStream 
			DataOutputStream out_flujo = new DataOutputStream( out_aux );
			
			out_flujo.writeUTF( mensajes[2] );

			while( true ) {
				
				//recojo flujo de datos del socket
				in_aux = skCliente.getInputStream();

				//asocio flujo de datos flujo de tipo DataInputStream
				in_flujo = new DataInputStream( in_aux );

				String mensaje_client = in_flujo.readUTF();
				System.out.println( mensaje_client );


				//asocio flujo salida de datos al socket
				out_aux = skCliente.getOutputStream();
				
				//asocio flujo de datos flujo de tipo DataOutputStream 
				out_flujo= new DataOutputStream( out_aux );
				
				if( mensaje_client != "Adios" ) {

					//escribo
					out_flujo.writeUTF( mensajes[3] );

				} else {

					//escribo
					out_flujo.writeUTF( mensajes[4] );
					
					//cierro conexión
					skCliente.close();

				}
				

			}

		} catch( Exception e ) {

			System.out.println( e.getMessage() );

		}

	}

	public static void main( String[] arg ) {

		new Servidor();

	}

}
