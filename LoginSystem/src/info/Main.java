package info;

public class Main {

	public static void main(String[] args) {
		
		Idpass idp = new Idpass();
		
		Loginpage lpg = new Loginpage(idp.getLoginInfo());
		

	}

}
