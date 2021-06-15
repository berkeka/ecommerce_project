package final_project.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DebitCard {
	@XmlElement private String id;
	@XmlElement private String cvc;
	@XmlElement private String date;
	private double balance;
	
	public DebitCard() {
		
	}
	
	public DebitCard(String id, String cvc, String date) {
		setId(id);
		setCvc(cvc);
		setDate(date);
		setBalance(0);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
