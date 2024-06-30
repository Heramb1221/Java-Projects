package info;

import java.util.HashMap;

public class Idpass {
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	Idpass(){
		
		logininfo.put("Heramb","12345678");
		logininfo.put("Brpmetheus", "PASSWORD");
		logininfo.put("Kunal", "abc123");
		
	}
	
	protected HashMap getLoginInfo() {
		return logininfo;
	}

}
