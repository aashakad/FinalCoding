package rocketServer;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class RocketHubTest {

	@Test
	public void test() {
	   try {
		RocketHub testr = new RocketHub(1521);
		//testr.messageReceived(1234, message);
		
	} catch (IOException e) {
		System.out.println("Invalid port id");
	}
	   
	}

}
