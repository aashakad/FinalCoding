package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	RateDomainModel rdm;
	
	public RateException(RateDomainModel r) {
		rdm = r;	
	}

	public RateDomainModel getRdm() {
		return rdm;
	}
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateDomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
