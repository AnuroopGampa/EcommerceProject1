package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Card_Details")
public class Card {
	@Id
	@Column(name="Cardid")
	@GeneratedValue
	private int payid;
	
	
private String card_name;
	
	private long card_number;

	private int userid;

	/*public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}*/

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public long getCard_number() {
		return card_number;
	}

	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
}
