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
	private ServerSocket socketServer;
	private Socket conexion;
	private Butaca[] cenButacas;
	private Butaca[] lat1Butacas;
	private Butaca[] lat2Butacas;
	private Butaca[] galButacas;
	private Butaca[] vip1Butacas;
	private Butaca[] vip2Butacas;
	private int cenButacasLibres;
	private int lat1ButacasLibres;
	private int lat2ButacasLibres;
	private int galButacasLibres;
	private int vip1ButacasLibres;
	private int vip2ButacasLibres;

	public Servidor( ) {

		try {

			//crea socket 
			this.socketServer = new ServerSocket( PUERTO );

			// Asignar Cantidad de butacas
			cenButacasLibres 	= 54;
			lat1ButacasLibres 	= 4;
			lat2ButacasLibres 	= 4;
			galButacasLibres 	= 8;
			vip1ButacasLibres 	= 3;
			vip2ButacasLibres 	= 3;

			// Preparar Arrays
			this.cenButacas 	= new Butaca[cenButacasLibres];
			this.lat1Butacas 	= new Butaca[lat1ButacasLibres];
			this.lat2Butacas 	= new Butaca[lat2ButacasLibres];
			this.galButacas 	= new Butaca[galButacasLibres];
			this.vip1Butacas 	= new Butaca[vip1ButacasLibres];
			this.vip2Butacas 	= new Butaca[vip2ButacasLibres];
			
			for( int n = 0; n < cenButacasLibres; n++ ) { 

				cenButacas[n] = new Butaca( "CEN", n, 80 );

			}

			for( int n = 0; n < lat1ButacasLibres; n++ ) { 

				lat1Butacas[n] = new Butaca( "LAT1", n, 100 );

			}			

			for( int n = 0; n < lat2ButacasLibres; n++ ) { 

				lat2Butacas[n] = new Butaca( "LAT2", n, 100 );

			}
			
			for( int n = 0; n < galButacasLibres; n++ ) { 

				galButacas[n] = new Butaca( "GAL", n, 150 );

			}

			for( int n = 0; n < vip1ButacasLibres; n++ ) { 

				vip1Butacas[n] = new Butaca( "VIP1", n, 250 );

			}

			for( int n = 0; n < vip2ButacasLibres; n++ ) { 

				vip2Butacas[n] = new Butaca( "VIP2", n, 250 );

			}

			// Mensajes del servidor
			mensajes[0] = "Esperando conexión...";
			mensajes[1] = "Conectado.";
			mensajes[2] = "Hola, soy el servidor.";
			mensajes[3] = "Elige una opcion:\n";
			mensajes[3] += "Reserva (tipoButaca) (númeroButaca)\n";
			mensajes[3] += "Ver Butacas\n";
			mensajes[3] += "Fin\n";
			mensajes[4] =  "Hasta luego";

		} catch( Exception e ) {

			System.out.println( e.getMessage() );

		}
	}
	public void listen() {

		try {

			String mensaje = "";
			while(true) { 

				// Esperando conexiones
				System.out.println(mensajes[0]);
				this.conexion = socketServer.accept();
				
				System.out.println( mensajes[1] );
			
				if( ! lectura().equalsIgnoreCase( "Hola" ) ) {

					conexion.close();

				}

				escritura(mensajes[2]);
				while(true){

					escritura(mensajes[3]);
					


					if( lectura() == "Ver Butacas" ) {

						mensaje = "Butacas de tipo CEN hay "+cenButacasLibres+" libres con un precio de "+ cenButacas[1].precio +"€\n";
						mensaje += "Butacas de tipo LAT1 hay "+lat1ButacasLibres+" libres con un precio de "+ lat1Butacas[1].precio +"€\n";
						mensaje += "Butacas de tipo LAT2 hay "+lat2ButacasLibres+" libres con un precio de "+ lat2Butacas[1].precio +"€\n";
						mensaje += "Butacas de tipo GAL hay "+galButacasLibres+" libres con un precio de "+ galButacas[1].precio +"€\n";
						mensaje += "Butacas de tipo VIP1 hay "+vip1ButacasLibres+" libres con un precio de "+ vip1Butacas[1].precio +"€\n";
						mensaje += "Butacas de tipo VIP2 hay "+vip2ButacasLibres+" libres con un precio de "+ vip2Butacas[1].precio +"€\n";
					}

				}

			}

		} catch( Exception e ) {

			System.out.println( e.getMessage() );

		}
	}

	public String lectura() {

		String mensaje = "";
		try {

			InputStream input = this.conexion.getInputStream();
			DataInputStream dataInput = new DataInputStream( input );
			mensaje = dataInput.readUTF();
			System.out.println( "Cliente: " + mensaje );
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
		}catch( Exception e ) {

			System.out.println( e.getMessage() );
		}
	}

	public Butaca[] getCenButacas() {
		return this.cenButacas;
	}

	public Butaca[] getLat1Butacas() {
		return this.lat1Butacas;
	}

	public Butaca[] getLat2Butacas() {
		return this.lat2Butacas;
	}

	public Butaca[] getGalButacas() {
		return this.galButacas;
	}

	public Butaca[] getVip1Butacas() {
		return this.vip1Butacas;
	}

	public Butaca[] getVip2Butacas() {
		return this.vip2Butacas;
	}

	public int getCenButacasLibres() {
		return this.cenButacasLibres;
	}

	public void setCenButacasLibres(int butacas) {
		this.cenButacasLibres = butacas;
	}

	public int getLat1ButacasLibres() {
		return this.lat1ButacasLibres;
	}

	public void setLat1ButacasLibres(int butacas) {
		this.lat1ButacasLibres = butacas;
	}

	public int getLat2ButacasLibres() {
		return this.lat2ButacasLibres;
	}

	public void setLat2ButacasLibres(int butacas) {
		this.lat2ButacasLibres = butacas;
	}
	public int getGalButacasLibres() {
		return this.galButacasLibres;
	}

	public void setGalButacasLibres(int butacas) {
		this.galButacasLibres = butacas;
	}

	public int getVip1ButacasLibres() {
		return this.vip1ButacasLibres;
	}

	public void setVip1ButacasLibres(int butacas) {
		this.vip1ButacasLibres = butacas;
	}

	public int getVip2ButacasLibres() {
		return this.vip2ButacasLibres;
	}

	public void setVip2ButacasLibres(int butacas) {
		this.vip2ButacasLibres = butacas;
	}

	public static void main( String[] arg ) {
		
		Servidor servidor = new Servidor();

		servidor.listen();


	}

}
