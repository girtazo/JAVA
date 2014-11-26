
public class TICTAC extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TIC tic = new TIC();
		TAC tac = new TAC();
		try {
			tic.start();
			tac.start();
		} catch (/*Interrupted*/Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
