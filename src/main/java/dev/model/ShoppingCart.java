package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShoppingCart {
	private long id;
	private long productId;
	private int quantity;
	private String dateAdded;
	
	public ShoppingCart() {}
	public ShoppingCart(long productId, int quantity, String dateAdded) {
		this.productId = productId;
		this.quantity = quantity;
		this.dateAdded = dateAdded;
	}
	public ShoppingCart(long id, long productId, int quantity, String dateAdded) {
		this.id = id;
		this.productId = productId;
		this.quantity = quantity;
		this.dateAdded = dateAdded;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
}