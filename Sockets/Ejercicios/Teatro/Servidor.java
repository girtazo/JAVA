import java.io.* ;
import java.net.* ;
//Servidor espera conexiones a las que atenderá con un segundo socket
//Servidor saludará con frase "Hola cliente"
class Butaca {

	public String tipo;
	public int numero;
	public float precio;
	public Boolean ocupada = false;

	public Butaca( String tipo, int numero, float precio ) {

		this.tipo 		= tipo;
		this.numero 	= numero;
		this.precio 	= precio;
		this.ocupada 	=  false;

	}

}

class Servidor {

	//puerto espera conexiones
	static final int PUERTO = 5000;
	private String[] mensajes = new String[5];

	public Servidor( ) {

		try {

			mensajes[0] = "Esperando conexión...";
			mensajes[1] = "Conectado.";
			mensajes[2] = "Hola, soy el servidor.";
			mensajes[3] = "Muy bien.";
			mensajes[4] =  "Hasta luego";
			
			//crea socket 
			ServerSocket skServidor = new ServerSocket( PUERTO );
			

			while(true) { 

				// Esperando conexiones
				System.out.println(mensajes[0]);
				Socket conexion = skServidor.accept();
				System.out.println( mensajes[1] );

				// Esperando Inicio del cliente
				InputStream input = conexion.getInputStream();
				DataInputStream dataInput = new DataInputStream( input );
			
				if( ! dataInput.readUTF( ).equalsIgnoreCase( "Hola" ) ) {

					conexion.close();

				}

				// Envio respuesta al cliente como aviso de conexion
				OutputStream output = conexion.getOutputStream();
				
				DataOutputStream dataOutput = new DataOutputStream( output );
			
				dataOutput.writeUTF( mensajes[2] );

			}
			

			// while( true ) {
				
			// 	//recojo flujo de datos del socket
			// 	input = conexion.getInputStream();

			// 	//asocio flujo de datos flujo de tipo DataInputStream
			// 	data = new DataInputStream( input );

			// 	String mensaje_client = data.readUTF();
			// 	System.out.println( mensaje_client );


			// 	//asocio flujo salida de datos al socket
			// 	out_aux = conexion.getOutputStream();
				
			// 	//asocio flujo de datos flujo de tipo DataOutputStream 
			// 	out_flujo= new DataOutputStream( out_aux );
				
			// 	if( mensaje_client.equalsIgnoreCase( "Adios" ) ) {

			// 		out_flujo.writeUTF( mensajes[4] );
					
			// 		//cierro conexión
			// 		conexion.close();

			// 	} else {

			// 		out_flujo.writeUTF( mensajes[3] );
			// 		//escribo
					

			// 	}
				

			// }

		} catch( Exception e ) {

			System.out.println( e.getMessage() );

		}

	}

	public static void main( String[] arg ) {

		Butaca[] cenButacas = new Butaca[54];

		for( int n = 0; n < 54; n++ ) { 

			cenButacas[n] = new Butaca( "CEN", n, 80 );

		}

		Butaca[] lat2Butacas = new Butaca[4];

		for( int n = 0; n < 4; n++ ) { 

			lat2Butacas[n] = new Butaca( "LAT2", n, 100 );

		}

		Butaca[] lat1Butacas = new Butaca[4];

		for( int n = 0; n < 4; n++ ) { 

			lat1Butacas[n] = new Butaca( "LAT1", n, 100 );

		}

		Butaca[] galButacas = new Butaca[8];

		for( int n = 0; n < 8; n++ ) { 

			galButacas[n] = new Butaca( "GAL", n, 150 );

		}

		Butaca[] vip1Butacas = new Butaca[3];

		for( int n = 0; n < 3; n++ ) { 

			vip1Butacas[n] = new Butaca( "VIP1", n, 250 );

		}

		Butaca[] vip2Butacas = new Butaca[3];

		for( int n = 0; n < 3; n++ ) { 

			vip2Butacas[n] = new Butaca( "VIP2", n, 250 );

		}

		new Servidor();


	}

}
