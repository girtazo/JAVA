import java.io.*;
import java.util.Scanner;

public class CasiBash{
	
	public static void main(String[]args){

	Scanner scanner = new Scanner(System.in);

	System.out.println("Introduce comando");
	String command = scanner.nextLine();

	Runtime runtime = Runtime.getRuntime();
	Process process;

	try{
		process = runtime.exec(command);
	}catch(Exception e){
		System.out.printf("Error al lanzar el comando: %s\n", command);
		e.printStackTrace();
	}

	}
}