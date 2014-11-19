
public class TAC extends Thread{
	public void run(){
		while(true){
				System.out.println("TAC");
			try {
				this.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
