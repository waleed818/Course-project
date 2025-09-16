package bigproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;
import java.util.List;   
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;






public class testbig extends data {
	

	WebDriver driver = new EdgeDriver();
	
	Connection con ;
    Statement stmt ;
    ResultSet rs ;
	

	@BeforeTest
	public void geturl() throws SQLException {

		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodel","root","root");
		
	}
    
	@Test (priority = 1,enabled = false)
	public void signup () throws InterruptedException {
		
		
		driver.navigate().to("https://automationteststore.com/index.php?rt=account/create");
		
		
		//elemnts signup
		
		WebElement Firstname = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement lastname = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement email = driver.findElement(By.id("AccountFrm_email"));
		WebElement tele = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement fax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement country= driver.findElement(By.id("AccountFrm_country_id"));
		WebElement state = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement Company = driver.findElement(By.id("AccountFrm_company"));
		WebElement Addres = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement City = driver.findElement(By.id("AccountFrm_city"));
		WebElement Zip = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement Logname = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement Password= driver.findElement(By.id("AccountFrm_password"));
		WebElement rePassword = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement yes = driver.findElement(By.id("AccountFrm_newsletter1"));
		WebElement agree = driver.findElement(By.id("AccountFrm_agree"));
		WebElement coutinue = driver.findElement(By.xpath("//button[@title='Continue']"));
		
		
	     // تستخدم هذه الطريقه في حال كان النص بنجاح العمليه له كلاسس نيم او ايدي او ما شابه
		String Actual = driver.findElement(By.className("maintext")).getText();
		
		
		// مقارنه
		Assert.assertEquals(Actual, Theexpectedsignup );   		//  خليك تقارن بين شيئين في الي لازم يصير والي صار فعلا

	  System.out.println(Theexpectedsignup);
		
		//select country
	
	
		Select mycountry = new Select(country);
		mycountry.selectByIndex(108);
		
		Thread.sleep(2000);
		Select mystate = new Select(state);
		mystate.selectByIndex(8);
		
	    
	      
	  
		//actions to signup
		
		Firstname.sendKeys(thefirstname);
	    lastname.sendKeys(thelastname);
	    email.sendKeys(theemail);
	    tele.sendKeys(telephone);
	    fax.sendKeys(TheFax);
	    Company.sendKeys(company);
	    Addres.sendKeys(addres);
	    City.sendKeys(addres);
	    Zip.sendKeys(zip);
	    Logname.sendKeys(thelognames);
	    Password.sendKeys(password);
	    rePassword.sendKeys(password);
	    yes.click();
	    agree.click();
	    coutinue.click();
	  
	}

	
	@Test (priority = 2,enabled = false)
	
	public  void logout () {
		
		
	
		WebElement logoutbottom = driver.findElement(By.partialLinkText("Log"));
		logoutbottom.click();
		
		// تستخدم هذه الطريقه في حال كان النص المظاهر بنجاح العمليه لا يوجد به كلاسس نيم او ايدي او ما شابه 
		 boolean Actuallogout =  driver.getPageSource().contains(Theexpectedlogout);
		
		
		//  مقارنه بين هل راح يكون جملة التوقع نفسها الي صار فعلا او لا
	
	        Assert.assertEquals(Actuallogout, true);
	
	        System.out.print(Actuallogout);
	}
	
	
	@Test (priority = 3,enabled = false)
	
	public void Login () {
		
		WebElement loginbottom = driver.findElement(By.cssSelector("ul[id='customer_menu_top'] li a"));
		loginbottom.click();
	
		
		
		WebElement loginuser = driver.findElement(By.cssSelector("#loginFrm_loginname"));
		WebElement loginpass = driver.findElement(By.cssSelector("#loginFrm_password"));
		WebElement bottonlogin = driver.findElement(By.cssSelector("button[title='Login']"));
		
		loginuser.sendKeys(thelognames);
		loginpass.sendKeys(password);
		bottonlogin.click();;
		
		
		boolean Actuallogin = driver.getPageSource().contains(Theexpectedlogin);
		
		boolean Theexpectedlogin = true ;
		
		Assert.assertEquals(Actuallogin, Theexpectedlogin);
		
	}
	
	@Test (priority = 4,enabled = true)
	
	public void additmes () {
		
		driver.navigate().to("https://automationteststore.com/");
		
		   Random rand = new Random();
		   
		 for (int i = 0 ; i < 10 ; i++) {
			 
			 List <WebElement> additem = driver.findElements(By.className("prdocutname"));
			 
			 int randomitem = rand.nextInt(additem.size());
			 
			 additem.get(randomitem).click();
			 
			 
			 boolean Outofstouk = driver.getPageSource().contains("Out of Stock");
			 
			 
			 if (! Outofstouk) {
				 
				 driver.findElement(By.cssSelector(".cart")).click();
				 
				 return;
			 }
			 
			 driver.navigate().back();
		 }
		 
			 throw new RuntimeException("No Found item");
			 
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	
	public void After () {
		
		//driver.close();
		
		//driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
