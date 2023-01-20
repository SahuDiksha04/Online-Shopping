package Practise_Package;

import org.testng.annotations.Test;

public class SampleTestng2_Test {
	
	@Test(groups = {"Smoke"})
	public void sample3()
	{
		System.out.println("sampletest3");
	}
	
	@Test(groups = {"Regression"})
	public void sample4()
	{
		System.out.println("sampletest4");
	}

}
