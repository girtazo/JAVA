
public class Person extends Thread {
	
	private String name;
	private Account account;
	
	public Person(String name, Account account){
		this.name = name;
		this.account = account;
	}
	
	public void run(){
		int money;
		
		for(int i = 0; i < 2; i++){
			money = getRandomInteger();
			System.out.printf("%S dice --> Añadamos %d a la cuenta...\n",
					name, money);			
			account.addMoney(money);
			
			money = getRandomInteger();
			System.out.printf("%S dice --> Cojamos %d a la cuenta...\n",
					name, money);			
			account.substractMoney(money);						
		}
	}
	
	public int getRandomInteger(){
		return (int) (Math.random() * (500 - 1) + 1);
	}
}
