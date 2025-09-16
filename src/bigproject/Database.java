package bigproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Database {
	
    Connection con ;
	
	Statement stmt ;
	
	ResultSet rs ;
	
	
	@BeforeTest 
		
	 public void geturl () throws SQLException {
		
		con = DriverManager.getConnection("jdbc:MySql://Localhost:3306/classicmodel","root","root");
		
		
	} 
		
		
	
	@Test 
	
	public void CreateData () {
		
		
		
	}
	
	
	
	@Test 
	
	public void readData () {
		
		
		
	}
	
	
	
	@Test 
	
	public void updateData () {
		
		
		
	}
	
	
	
	
	@Test 
	
	public void deletData () {
		
		
		
	}
	
	
	
	
	
	

}