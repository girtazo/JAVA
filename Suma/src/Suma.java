import java.io.*;
public class Suma {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (in);
	
		try{
			System.out.println("Introduce el numero 1:");
			String cadena=br.readLine();
			
			int numero1 = Integer.parseInt(cadena);
			System.out.println("Introduce el numero 2:");
			String cadena2=br.readLine();
			int numero2 = Integer.parseInt(cadena2);
			int suma = numero1 + numero2;
			System.out.println("El resultado es: "+String.valueOf(suma));
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
