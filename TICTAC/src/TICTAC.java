
public class TICTAC extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TIC tic = new TIC();
		TAC tac = new TAC();
		try {
			tic.sleep(1000);
			tic.start();
			tic.sleep(1000);
			tac.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
