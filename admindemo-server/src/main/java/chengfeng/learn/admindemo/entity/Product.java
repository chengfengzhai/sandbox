package chengfeng.learn.admindemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Serializable{
	@Id
	@Column(name="ID")
	// GenerationType.AUTO seems not auto-created value when directly using SQL insert.
	//Instead, GenerationType.IDENTITY will auto-created value even when directly using SQL insert
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private String description;
	
	@Column(columnDefinition="NUMBER(6,2)")
	private Double price;
	
	@Enumerated(EnumType.STRING) //default type is mini integer
	private ProductCategary categary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ProductCategary getCategary() {
		return categary;
	}

	public void setCategary(ProductCategary categary) {
		this.categary = categary;
	}

}
