import java.io.*;

public class AdderManager{
	public static void main(String[]args){

		final String COMMAND = "java Adder";
		final String INPUT_DATA = "10\n";

		Runtime runtime = Runtime.getRuntime();
		Process process;

		try{
			process = runtime.exec(COMMAND);
		}catch(IOException ioex){
			ioex.printStackTrace();
		}

	}
}