package edu.worcester.cs.kwurst.cs443;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.worcester.cs.kwurst.cs443.Order;
import mockit.Mocked;
import mockit.Expectations;

public class OrderInteractionTest {
	@Mocked Warehouse warehouse;
	@Mocked MailService mailer;
	@Mocked Message message;
	
	@Test
	public void testOrderSendsMailIfUnfilled() {
		Order order = new Order("Talisker", 51);
		
		order.setMailer(mailer);
		
		new Expectations() {{
			mailer.send((Message) any); times=1;
			warehouse.hasInventory(anyString, anyInt); returns(false); times=1;
		}};
		
		boolean result = order.fill(warehouse);
		assertFalse(result);
		
	}

}
