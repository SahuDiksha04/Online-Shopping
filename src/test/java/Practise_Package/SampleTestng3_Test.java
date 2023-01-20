package Practise_Package;

import org.testng.annotations.Test;

public class SampleTestng3_Test {
	
	@Test(groups = {"Smoke"})
	public void sample5()
	{
		System.out.println("sampletest5");
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void sample6()
	{
		System.out.println("sampletest6");
	}

}
