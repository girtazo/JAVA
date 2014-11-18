import java.io.*;
public class parametros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runtime r=Runtime.getRuntime();
		String comando="java ./Suma"; //comando a ejecutar
		Process p=null;
		String linea;
		try{
			p=r.exec(comando);
			p.waitFor();
			// Ejecucion normal antes de enviar datos
			InputStream respuesta=p.getInputStream();
			BufferedReader lector=new BufferedReader(new InputStreamReader (respuesta));
			
			// Lectura
			while ((linea=lector.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			// Ejecucion de errores antes de enviar datos
			InputStream error = p.getErrorStream();
			BufferedReader lectorError=new BufferedReader(new InputStreamReader(error));
			
			// Lectura
			while ((linea=lector.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			OutputStream os=p.getOutputStream();
			os.write("5".getBytes());
			os.flush(); //vacio buffer
			
			// Ejecucion normal primer elemento enviado
			respuesta=p.getInputStream();
			lector=new BufferedReader(new InputStreamReader (respuesta));
			
			// Lectura
			while ((linea=lector.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			// Ejecucion de errores primer elemento enviado
			error=p.getErrorStream();
			lectorError=new BufferedReader(new InputStreamReader (error));
			
			// Lectura
			while ((linea=lectorError.readLine())!=null)
			{
				System.out.println(linea);
			}
			
			os.write("3".getBytes());
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
			
			error.close();
			respuesta.close();
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
