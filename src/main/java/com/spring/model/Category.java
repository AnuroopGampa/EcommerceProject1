package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryid;
	
	@Column(name="categoryName,categoryDescription")
	private String categoryName,categoryDescription;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="category")
	public Integer getCategoryId() {
		return categoryid;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryid = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
