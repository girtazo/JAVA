import java.io.*;
public class parametros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r=Runtime.getRuntime();
		String comando="java Suma"; //comando a ejecutar
		Process p=null;
		String linea;
		InputStream respuesta;
		BufferedReader lector;
		InputStream error;
		BufferedReader lectorError;
		try{
			p=r.exec(comando);
			
			OutputStream os=p.getOutputStream();
			os.write("5\n".getBytes());
			os.flush(); //vacio buffer
	
			os.write("3\n".getBytes());
			os.flush();
			
			// Ejecucion normal segundo elemento enviado
			respuesta=p.getInputStream();
			lector=new BufferedReader(new InputStreamReader (respuesta));
			
			// Lectura
			while ((linea=lector.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			// Ejecucion de errores segundo elemento enviado
			error=p.getErrorStream();
			lectorError=new BufferedReader(new InputStreamReader (error));
			
			// Lectura
			while ((linea=lectorError.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			lector.close();
			lectorError.close();
			os.close();
			
		} catch(Exception e) {
			System.out.println ("Error en "+comando);
			e.printStackTrace();
		}
				
		//comprobación de error 0 bien - 1 mal
		int exitVal;
		try {
			exitVal=p.waitFor();
			System.out.println("Valor de salida "+exitVal);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
