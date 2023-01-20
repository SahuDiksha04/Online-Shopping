package Practise_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertProjectDetails_TY {

	public static void main(String[] args) throws SQLException {
		 Connection conn=null;
		int result=0;
		try {
		Driver driver = new Driver();
		//step1:Register the database
		
		DriverManager.registerDriver(driver);
		//step2:Get connection for the database
		
	  conn = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%","root");
	  //step3:Issue create statement
	  
	  Statement state = conn.createStatement();
	  String query = "insert into project values('OSA1','DS','12/12/22','Online_shopping','in-progress',3);";
	  
	  //step4: Update query
	  result=state.executeUpdate(query);
		}
		
		finally
		{
	    //step5:close the database
			if(result==1)
			{
				System.out.println("data successfully inserted");
			}
			else
			{
				System.out.println("data not inserted");
			}
			conn.close();
		}
	}
}


