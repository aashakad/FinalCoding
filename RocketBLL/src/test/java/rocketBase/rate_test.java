package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	@Test
	public void test(){
		double rFound = 0;
		
		try{ 
			rFound = RateBLL.getRate(750);
		} catch(RateException r) {
			System.out.println("ERROR: Rate not found");
		}	
		assertEquals( 5.75 , rFound , 0.001);
	}
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test(expected = RateException.class)
	public void testrateException() throws RateException {
		double rFound = 0;
		rFound = RateBLL.getRate(400); 
	}
}
