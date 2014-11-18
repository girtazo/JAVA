import java.io.*;
public class Suma{
	public static void main (String[] args){
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (in);
		String texto;
	
		try{
			System.out.println("Introduce el numero 1:");
			int numero1=br.readLine();
			System.out.println("Introduce el numero 2:");
			int numero2=br.readLine();
			suma = numero1 + numero2;
			System.out.println(String.valueOf(suma)));
			in.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}//fin main
}//fin ejemplo lectura