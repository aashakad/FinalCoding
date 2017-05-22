package rocketBase;

import static org.junit.Assert.*;
import rocketDomain.RateDomainModel;
import java.util.ArrayList;
import java.util.Iterator;


import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	@Test
	public void test() {
	//TODO - RocketDAL rate_test
	//		Check to see if a known credit score returns a known interest rate
	ArrayList<RateDomainModel> rates = new ArrayList<RateDomainModel>(); 
	rates = RateDAL.getAllRates();
	
	for (RateDomainModel r: rates) {
		if (r.getiMinCreditScore() == 600)
			assertEquals(7, r.getdInterestRate(), 0.01);
	}
	
	}

/*	@Test(expected = RateException.class)
	public void testrateException() throws RateException {
	// Run some code that will throw PersonException.class
	// This test will fail if that exception ISN'T thrown...!
	}*/
}
