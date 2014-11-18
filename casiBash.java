import java.io.*;
import java.util.*;
public class casiBash{
	private static String comando;
	private static Scanner escanear = new Scanner(System.in);
	private static Runtime r=Runtime.getRuntime();
	public static void main(String[] args) {
		comando = pedirComando();
		Process proceso;
		String linea = null;
		try{
			proceso=r.exec(comando);
			InputStream error = proceso.getErrorStream();
			BufferedReader lectorErroneos = new BufferedReader(new InputStreamReader(error));

			while((linea = lectorErroneos.readLine())!= null){
				System.out.println(linea);
			}

			InputStream respuesta=proceso.getInputStream();
			BufferedReader lector=new BufferedReader(new InputStreamReader (respuesta));
			
			while((linea = lector.readLine())!= null){
				System.out.println(linea);
			}
			try{
				int exitVal=proceso.waitFor();
				System.out.println("Valor de salida "+exitVal);
			} catch(InterruptedException e){

				e.printStackTrace();
			}
		} catch(Exception e){

		}
		
	}
	private static String pedirComando(){
		System.out.println("Introduce el comando a ejecutar:");
		comando = escanear.nextLine();
		return comando;
	}
}