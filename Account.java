import java.util.Scanner;

public class Account {
	//Class Variables
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//Class constructor
	Account(String cname, String cid) {
		customerName = cname;
		customerID = cid;
	}
	
	//Function for Depositing money
	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	//Function for Withdrawing money
	void withdraw(int amount) {
		if (amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//Function showing the previous transaction
	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Saque: " + Math.abs(previousTransaction));
		} else {
			System.out.println("Nenhuma transação ocorreu");
		}
	}
	
	//Function calculating interest of current funds after a number of years
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("O saldo atual é de " + (100 * interestRate) + "%");
		System.out.println("Após " + years + " anos, seu saldo será: " + newBalance);
	}
	
	//Function showing the main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bem vinda(o), " + customerName + "!");
		System.out.println("Seu ID é: " + customerID);
		System.out.println();
		System.out.println("O que você gostaria de fazer?");
		System.out.println();
		System.out.println("A. Checar seu saldo");
		System.out.println("B. Fazer um depósito");
		System.out.println("C. Fazer um saque");
		System.out.println("D. Ver extrato de transações");
		System.out.println("E. Calcular juros");
		System.out.println("F. Sair");
		
		do {
			System.out.println();
			System.out.println("Escolha uma opção: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			//Case 'A' allows the user to check their account balance
			case 'A':
				System.out.println("====================================");
				System.out.println("Saldo = R$" + balance);
				System.out.println("====================================");
				System.out.println();
				break;
			//Case 'B' allows the user to deposit money into their account using the 'deposit' function
			case 'B':
				System.out.println("Insira um valor a ser depositado: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
			//Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
			case 'C':
				System.out.println("Insira um valor para saque: ");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
			//Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
			case 'D':
				System.out.println("====================================");
				getPreviousTransaction();
				System.out.println("====================================");
				System.out.println();
				break;
			//Case 'E' calculates the accrued interest on the account after a number of years specified by the user
			case 'E':
				System.out.println("Insira quantos anos de juros acumulados: ");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
			//Case 'F' exits the user from their account
			case 'F':
				System.out.println("====================================");
				break;
			//The default case let's the user know that they entered an invalid character and how to enter a valid one
			default:
				System.out.println("Erro: opção inválida. Insira A, B, C, D ou E ou serviços de acesso.");
				break;
			}
		} while(option != 'F');
		System.out.println("Obrigada por nos escolher para ser seu banco!");
	}
	
}