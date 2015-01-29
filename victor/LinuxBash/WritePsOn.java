import java.io.*;

public class WritePsOn{
	public static void main(String [] args){
		
		final String DEFAULT_FILE = "ps.txt";
		String file = (args.length > 0) ? args[0] : DEFAULT_FILE;
		String command = "ps";

		Runtime runtime = Runtime.getRuntime();
		Process process;

		try{
			FileOutputStream fos = new FileOutputStream(file);
			PrintWriter printWriter = new PrintWriter(fos);
			
			process = runtime.exec(command);

			InputStream inputStream = process.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			String line;

			while((line = bufferedReader.readLine()) != null)
				printWriter.println(line);

			bufferedReader.close();
			printWriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}