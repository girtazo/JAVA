import java.util.Scanner;

public class Adder{
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduce el primer número: ");
		int firstNum = scanner.nextInt();

		System.out.println("Introduce el segundo número: ");
		int secondNum = scanner.nextInt();

		System.out.println(String.format("La suma de %d más %d es %d", 
			firstNum, secondNum, (firstNum + secondNum)));
	}
}