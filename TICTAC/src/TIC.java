
public class TIC extends Thread{
	public void run(){
		try {
			while(true){
				this.sleep(2000);
				System.out.print("TIC ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
