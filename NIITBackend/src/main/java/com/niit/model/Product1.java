
package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity

public class Product1 
{	
	
	private static final long serialVersionUID = 5186013952828648626L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String name;
	@Column
	private int quantity;
	@Column
	private double price;
	@Column
	private String p_category;
	
	
	public Product1()
	{}
	public Product1(int id, String name, int quantity, double price, String p_category) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.p_category = p_category;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getP_category() {
		return p_category;
	}


	public void setP_category(String p_category) {
		this.p_category = p_category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	


	
	
	
	
	/*public Product1(int id,String name,int quantity,double price)
	{
		super();
		this.id=id;
		this.name=name;
		this.quantity=quantity;
		this.price=price;
	}*/
}