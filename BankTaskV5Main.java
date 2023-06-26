package CoreJava10;

public class BankTaskV5Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankTaskV5 main = new BankTaskV5();
		BankTaskV5_user user = new BankTaskV5_user();
		BankTaskV5_admin admin = new BankTaskV5_admin();
		ChatBot bot = new ChatBot();
		
		main.log_in(user, admin, bot);
	}
}
