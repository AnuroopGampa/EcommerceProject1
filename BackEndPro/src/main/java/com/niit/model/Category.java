package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Category_Details")
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1573873551688338793L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="catid")
	private int Catid;
	private String CatName;
	private String CatDescription;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getCatid() {
		return Catid;
	}
	public void setCatid(int catid) {
		Catid = catid;
	}
	public String getCatName() {
		return CatName;
	}
	public void setCatName(String catName) {
		CatName = catName;
	}
	public String getCatDescription() {
		return CatDescription;
	}
	public void setCatDescription(String catDescription) {
		CatDescription = catDescription;
	}

}
