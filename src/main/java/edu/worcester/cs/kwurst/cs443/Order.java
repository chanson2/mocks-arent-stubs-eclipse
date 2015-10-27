package edu.worcester.cs.kwurst.cs443;

public class Order {

	private MailService mailer;
	private String name;
	private int qty;
	
	public Order(String name, int qty) {
		this.name = name;
		this.qty = qty;
	}
	
	public void setMailer(MailService mailer) {
		this.mailer = mailer;
	}
	
	public boolean fill(Warehouse warehouse) {
		boolean result = warehouse.hasInventory(name, qty);
		if (result==false) {
			mailer.send(new Message());
		}
		return result;
	}

}
