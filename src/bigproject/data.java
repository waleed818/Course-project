package bigproject;

import java.util.Random;

public class data {
	
	Random rand = new Random();
	
	String [] firstnames = {"waleed","nasser","ali","samer","sami"};
	String [] lastNames = {"hamad","omar","wael","hani","abood"};
	String domin ="@gmail.com";
	
	int randomFirstName = rand.nextInt(firstnames.length);
	int randomlastname = rand.nextInt(lastNames.length);
	int randomnuberemail = rand.nextInt(5050);
	
	
	String thefirstname = firstnames[randomFirstName];
	String thelastname = lastNames [randomlastname];
	String theemail = thefirstname+thelastname+randomnuberemail+domin;
	
	String telephone = "0796593340";
	String TheFax = "53445";
	
	String company = "waleed";
	String addres = "Amman";
	String city = "االرصيفه";
	String zip = "24323";
	
			
			
	        
	        String thelognames = thefirstname+thelastname+randomnuberemail;
	        
	        
	        String password = "2312432";
	        
	        
	        String Theexpectedsignup = "CREATE ACCOUNT";
	        
	        
	        String Theexpectedlogout = "You have been logged off your account. It is now safe to leave the computer.";
	         
	        
	       String Theexpectedlogin = "Welcome back "+thefirstname ;
}

