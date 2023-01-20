package Practise_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryPage {

	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		int result=0;
		try {
		
		Driver driver = new Driver();
		//step1:Register the database
		
	   
	    DriverManager.registerDriver(driver);
		//step2:get connection for the database
	    
	   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root","root");
		//step3:issue create statement
	   
	  Statement state =  conn.createStatement();
	  String query = "insert into studentinfo values('Anup','Rajajinagar','Communication',5);";
		//step4:update query
	 
	   result= state.executeUpdate(query);
	 
	 
		}
	 
	 catch(Exception e)
	 {
		 
	 }
		finally
		{
			if(result==1)
			{
			System.out.println("Data inserted successfully");
		}
			else
			{
				System.out.println("Data not inserted");
			}
		//step5:Close the database
			conn.close();
	}

}
}
