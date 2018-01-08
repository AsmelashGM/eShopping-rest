package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {
	private long id;
    private String customerid;
    private long productid;
    private Integer shippingid;
    private String datecreated;
    private String dateshipped;
    private Integer quantity;
    private Double totalcost;
    private String status;
    

	public Order() {}
	public Order(long id, String datecreated, String dateshipped, String customerid, Integer shippingid, String status,
			long productid, Integer quantity, Double totalcost) {
		this.id = id;
		this.datecreated = datecreated;
		this.dateshipped = dateshipped;
		this.customerid = customerid;
		this.shippingid = shippingid;
		this.status = status;
		this.productid = productid;
		this.quantity = quantity;
		this.totalcost = totalcost;
	}
	public Order(String datecreated, String dateshipped, String customerid, Integer shippingid, String status,
			long productid, Integer quantity, Double totalcost) {
		this.datecreated = datecreated;
		this.dateshipped = dateshipped;
		this.customerid = customerid;
		this.shippingid = shippingid;
		this.status = status;
		this.productid = productid;
		this.quantity = quantity;
		this.totalcost = totalcost;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	public String getDateshipped() {
		return dateshipped;
	}
	public void setDateshipped(String dateshipped) {
		this.dateshipped = dateshipped;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public Integer getShippingid() {
		return shippingid;
	}
	public void setShippingid(Integer shippingid) {
		this.shippingid = shippingid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}
}