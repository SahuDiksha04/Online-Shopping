package Practise_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDtabase {

	public static void main(String[] args) throws SQLException {
		
	
		
		Connection conn=null;
		try {
		
		Driver driver = new Driver();
		//step1:Register the database
		
	   
	    DriverManager.registerDriver(driver);
		//step2:get connection foe the database
	    
	   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root","root");
		//step3:issue create statement
	   
	  Statement state =  conn.createStatement();
	 String query = "select * from studentInfo;";
		//step4:execute query
	 
	 ResultSet result = state.executeQuery(query);
	 
	 
	 while(result.next())
	 {
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	 }
		}
	 
	 catch(Exception e)
	 {
		 
	 }
		finally {
		//step5:close the database
			conn.close();
			System.out.println("close the database connection successfully");
		

	}
	}

}
