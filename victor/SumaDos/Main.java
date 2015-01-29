import java.io.*;

public class Main{
	public static void main(String[]args){

		final String COMMAND = "java Adder";
		final String INPUT = "10\n";
		String line;

		Runtime runtime = Runtime.getRuntime();
		Process process;

		try{
			process = runtime.exec(COMMAND);

			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			OutputStream os = process.getOutputStream();

			System.out.println(br.readLine());
			for(int i = 0; i < 2; i++){
				os.write(INPUT.getBytes());
				os.flush();
				System.out.printf(INPUT);
				is = process.getInputStream();
				System.out.println(br.readLine());
			}

		}catch(IOException ioex){
			ioex.printStackTrace();
		}
	}
}