package au.amit.test.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ScoreCalculatorTest{
	
	private ScoreCalculator service = null;
	
	@Before
	public void setup() {
		service = new ScoreCalculator();
	}
	
	@Test
	public void testPositiveScn1(){
		String input = "1 2 3 4";
		int result = service.calculate(input);
		Assert.assertEquals(result, 10);
	}

	@Test
	public void testPositiveScn2(){
		String input = "9 1 9 1";
		int result = service.calculate(input);
		Assert.assertEquals(result, 29);
	}

	@Test
	public void testPositiveScn3(){
		String input = "1 1 1 1 10 1 1";
		int result = service.calculate(input);
		Assert.assertEquals(result, 18);
	}

	@Test
	public void testPositivePerfect(){
		String input = "10 10 10 10 10 10 10 10 10 10 10 10";
		int result = service.calculate(input);
		Assert.assertEquals(result, 300);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testWrongInput(){
		String input = "10 10 aaa 10 10 10 10 10";
		int result = service.calculate(input);
	}

}
