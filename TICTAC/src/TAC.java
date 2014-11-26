
public class TAC extends Thread{
	public void run(){
		try {
			this.sleep(1000);
			while(true){
				this.sleep(2000);		
				System.out.println("TAC");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
