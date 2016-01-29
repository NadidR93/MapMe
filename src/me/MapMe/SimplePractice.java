package me.MapMe;


import com.restfb.FacebookClient;
import com.restfb.DefaultFacebookClient;
import com.restfb.types.User;

public class SimplePractice {
	
	
	private String name="Oakton, VA";
	private String tylerLoc="someValue";
	
	
	public String getTylerLoc(){
		FacebookClient cl=new DefaultFacebookClient("CAACEdEose0cBAEZBMyBnk1maK6pPZBUnoVJPRMn48AASbvUWQUJAZCAyRM7rEgEXqOAnfecwWFiWJOWRQCZBZB0kZAJsmFXd8bpgns1cDqaExvgd102tDZAMWlc3OgueDN3h5FnKL1RcIzBitBBxKeZBVGr5uOsDOkcJM1XaeYnnNC9McYYjcdxA53ZB6Mq77nB0jP59ZAZCarZAXAZDZD");
		return tylerLoc;
		
	}
	public String getName(){
		return name;
		
	}
	public int recurr(int x,int y){
		if (x==y)
			return 1*y;
		else
			return x*recurr((x-1),y);
		
	}
	
	public int xx(){
		
		return 2;
	}
	
	
	public static void main(String [] args){
		SimplePractice sp=new SimplePractice();
		System.out.println(sp.recurr(7,4));
		
	}

}
