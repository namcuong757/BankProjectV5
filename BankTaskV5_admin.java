package CoreJava10;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;

public class BankTaskV5_admin extends BankTaskV5 implements Features{

	public BankTaskV5_admin()
	{
		super();
	}
	@Override
	public void user_check() {
		// TODO Auto-generated method stub
		int flag = 0, conti = -1;
		Scanner scanner = new Scanner(System.in);
		do {
			boolean valid = false;
			System.out.println("\n################# ADMIN AREA #################\n" );
			System.out.println("ADMIN AUTHENTICATION" );
			System.out.println("Enter your adminID:" );
			String user = scanner.nextLine();
			System.out.println("Enter user Admin Password:" );
			String pass = scanner.nextLine();
			
			System.out.println("----LOGGING IN...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int i = 0; i < 1; i++) {
				if(admin.equals(user) && admin_passWord.equals(pass)) {
					
					System.out.println("\n---Successfully Logging In---\n" );
					int cont = 0;
					do
					{
						while (!valid) {
							try {
								System.out.println("What do you want to do?");
								System.out.println("1. Print all users\n2. Add new user");
								System.out.println("Enter your choice");
								int choice = scanner.nextInt();

								switch (choice) {
								case 1:
									display_all();
									break;
								case 2:
									add_user();
									break;
								default:
									System.out.println("Invalid answer");
								}
								valid = true;
							} catch (InputMismatchException e) {
								System.out.println("Please enter numeric charater");
								scanner.nextLine();
							}
							// Consume the newline character
						}
						
						while (!valid) {
							try {
								System.out.print("Enter any number to return to menu\n0 to exit: ");
								cont = scanner.nextInt();
								valid = true;
							} catch (InputMismatchException e) {
								System.out.println("Invalid input. Please enter a valid number.");
								scanner.next();
							} 
						}
					}while(cont != 0);
					
					flag = 1;
					break;
				}
			}
			valid = false;
			if(flag == 0) {
				System.out.println("====Failed to log in====\n");
				break;
			}
			
			System.out.println("Would you like to retry log in?\n1. Yes\n2. No");
			while (!valid) {
				try {
					System.out.println("Enter your choice: ");
					conti = scanner.nextInt();
					valid = true;
				} catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid number.");
					scanner.next();
				} 
			}
			scanner.nextLine(); // Consume the newline character
		} while(conti != 2);
		say_bye();
		//scanner.close();
	}

	@Override
	public void say_bye() {
		// TODO Auto-generated method stub
		System.out.println("LOG OUT OF ADMIN");
	}
	public void display_all()
	{
		
		for(int i = 0; i < ids.size(); i++)
		{
			System.out.println("UserID: " + ids.get(i));			
			System.out.println("PassWord: " + passWords.get(i));			
			System.out.println("Balances: " + balances.get(i));		
			System.out.println("Name: " + names.get(i));		
			System.out.println("Address: " + addresses.get(i));;		
			System.out.println("Phone Number: " + phone_nums.get(i));
			System.out.println("---------------------" );
		}
		
	}
	public boolean add_user() throws InputMismatchException{
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		boolean valid = false;
		while (!valid) {
			try {
				System.out.println("Would you like to add a new user?\n1. Yes\n2. No");
				choice = scanner.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				scanner.next();
			} 
		}
		valid = false;
		scanner.nextLine();
		if(choice == 1)
		{
			System.out.println("== ADDING NEW USER ==" );
			System.out.println("Enter user userID:" );
			String user = scanner.nextLine();
			System.out.println("Enter user password:" );
			String pass = scanner.nextLine();
			System.out.println("Enter user balance:" );
			int balance = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter user Name:" );
			String name = scanner.nextLine();
			System.out.println("Enter user Address:" );
			String address = scanner.nextLine();
			System.out.println("Enter user PhoneNumbers:" );
			String phone = scanner.nextLine();
			
			super.ids.add(user);
			super.passWords.add(pass);
			super.balances.add((long)balance);
			super.names.add(name);
			super.addresses.add(address);
			super.phone_nums.add(phone);
			System.out.println("-Succefully Added-" );
			return true;
		}
		return false;
	}

}
