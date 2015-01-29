
public class Account {
	private int max = 10000;
	private int money = 0;	
	
	public Account(int max, int money){
		this.max = max;
		this.money = money;
	}
	
	public int getMoney(){
		return money;
	}
	
	synchronized public void addMoney(int money){
		if( this.money + money > max){
			try {
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		this.money += money;
		System.out.printf("Añadido %d€ a la cuenta. Saldo actual: %d€\n", 
				money, this.money);		 
		notifyAll();
	}
	
	synchronized public void substractMoney(int money){
		if(this.money - money < 0){
			try {
				wait();
			} catch (InterruptedException e) {e.printStackTrace();}
		}		
		this.money -= money;
		System.out.printf("%d€ sacados. Saldo actual: %d€\n",
				money, this.money);
		notifyAll();
	}
}
