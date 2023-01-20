package Practise_Package;

import org.testng.annotations.Test;

public class SampleTestng_1 {
	
	@Test(groups = {"Smoke"})
	public void sample1()
	{
		System.out.println("sampletest1");
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void sample2() 
	{
		System.out.println("sampletest2");
	}
	
	

}
