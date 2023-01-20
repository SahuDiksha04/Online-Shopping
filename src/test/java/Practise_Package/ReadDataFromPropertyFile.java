package Practise_Package;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/java/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String Aurl = p.getProperty("AUrl");
		String Aun = p.getProperty("AUsername");
		String Apwd = p.getProperty("APassword");
		
		String Uurl = p.getProperty("Uurl");
		String Uun = p.getProperty("Uusername");
		String Upwd = p.getProperty("Upassword");
		
		System.out.println(Aurl);
		System.out.println(Aun);
		System.out.println(Apwd);
		
		System.out.println(Uurl);
		System.out.println(Uun);
		System.out.println(Upwd);
		
		
	}

}
