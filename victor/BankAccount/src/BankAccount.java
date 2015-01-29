
public class BankAccount {
	public static void main(String[]args){
		Account account = new Account(5000, 500);
		Person Juan = new Person("Juan", account);
		Person Pepe = new Person("Pepe", account);
		Juan.start();
		Pepe.start();
	}
}
