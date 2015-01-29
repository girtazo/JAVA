public class Actividad2_1{
	public static void main(String[]args){
		TIC tic = new TIC();
		TAC tac = new TAC();

		tic.start();
		tac.start();
	}

	private static class TIC extends Thread{
		private String sound = "TIC";

		public TIC(){}

		// Ambos metodos run son identicos en TIC y TAC. La creacion de una tercera clase
		// de la que heredar podria evitar esta duplicacion de codigo
		public void run(){ 
			while(true){
				try{
					sleep(1);
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
				System.out.printf(sound); 
			}
		}
	}

	private static class TAC extends Thread{
		private String sound = "TAC";

		public TAC(){}

		public void run(){ 
			while(true){
				try{
				sleep(1);
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
				System.out.printf(sound); 
			}
		}
	}
}