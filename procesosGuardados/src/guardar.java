import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class guardar {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String archivo = "svhost.txt";
			Runtime lanzador = Runtime.getRuntime();
			String comando="ps";
			Process proceso=null;
			String linea;
			int exitVal;
		try{
			
			proceso = lanzador.exec(comando);
			
			FileOutputStream indiceArchivo = new FileOutputStream(archivo);
			PrintWriter modoescritura = new PrintWriter(indiceArchivo);

			InputStreamReader lectura = new InputStreamReader(proceso.getInputStream());
			BufferedReader lector = new BufferedReader (lectura);
	
			while ((linea=lector.readLine())!=null)
			{
				modoescritura.println(linea);
			}
			modoescritura.close();
			System.out.println("Se guardaron los procesos actuales en SVHOST.TXT");
			try {
				exitVal=proceso.waitFor();
				System.out.println("Valor de salida "+exitVal);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
	}

}
