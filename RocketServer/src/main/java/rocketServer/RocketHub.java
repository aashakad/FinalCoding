package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			int cs= lq.getiCreditScore();
			double rFound = 0;
			
			try{ 
				rFound = RateBLL.getRate(cs);
			} catch(RateException r) {
				System.out.println("ERROR: Rate not found");
			}
			if (rFound != 0) {
				lq.setdRate(rFound);
				// getPayment(double r, double n, double p, double f, boolean t)
				double n = (lq.getiTerm()*12);
				double p = (lq.getdAmount()-lq.getiDownPayment());
				double f = p* Math.pow((1 + rFound),n);
				
				double Payment =
						RateBLL.getPayment(rFound, n, p, f, false);
				lq.setdPayment(Payment);
			}
				
			
			//	TODO - RocketHub.messageReceived

			//	You will have to:
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			//	Determine if payment, call RateBLL.getPayment
			//	
			//	you should update lq, and then send lq back to the caller(s)
			
			sendToAll(lq);
		}
	}
}
