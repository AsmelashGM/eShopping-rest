package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	
	private long id;
    private String name;
    private String description;
    private String type;
    private String measurement;
    private Double unitprice;
    private Integer quantity;
    private String imageName;
    private int size;
    
	public Product() {}
	public Product(long id, String name, String description, String type, 
			       String measurement, Double unitprice, Integer quantity, 
			       String imageName, int size) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.measurement = measurement;
		this.unitprice = unitprice;
		this.quantity = quantity;
		this.imageName = imageName;
		this.size = size;
	}
	public Product(String name, String description, String type, 
				   String measurement, Double unitprice, 
				   Integer quantity, String imageName, int size) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.measurement = measurement;
		this.unitprice = unitprice;
		this.quantity = quantity;
		this.imageName = imageName;
		this.size = size;
	}
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public Double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
    public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}