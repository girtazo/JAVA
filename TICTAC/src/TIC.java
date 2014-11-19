
public class TIC extends Thread{
	public void run(){
		while(true){
			System.out.println("TIC");
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
