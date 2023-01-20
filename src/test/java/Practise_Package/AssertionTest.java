package Practise_Package;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	public void sample1()
	{
		System.out.println("testscript1");
		System.out.println("testscript2");
	    assertEquals("A", "B");
	    System.out.println("testscript3");
		System.out.println("testscript4");
	}
	
	
	@Test
	public void sample2()
	{
		System.out.println("testscript5");
		System.out.println("testscript6");
		assertEquals("A", "B", "Stringisvalid");
		System.out.println("testscript7");
		System.out.println("testscript8");
	}
	
	@Test
	public void sample3()
	{
		String a=null;
		assertNull(a);
		System.out.println("testscript9");
	}
	
	@Test
	public void sample4()
	{
		System.out.println("test10");
		SoftAssert s = new SoftAssert();
		s.assertEquals("X", "Y");
		s.assertAll();
		System.out.println("test11");
		
	}
	
	

}
