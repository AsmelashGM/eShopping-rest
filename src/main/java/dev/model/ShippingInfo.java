package dev.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ShippingInfo {
    private long id;
    private String shippingtype;
    private Double shippingcost;
    
    public ShippingInfo() {}
	public ShippingInfo(String shippingtype, Double shippingcost) {
		this.shippingtype = shippingtype;
		this.shippingcost = shippingcost;
	}
	public ShippingInfo(long id, String shippingtype, Double shippingcost) {
		this.id = id;
		this.shippingtype = shippingtype;
		this.shippingcost = shippingcost;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getShippingtype() {
		return shippingtype;
	}
	public void setShippingtype(String shippingtype) {
		this.shippingtype = shippingtype;
	}
	public Double getShippingcost() {
		return shippingcost;
	}
	public void setShippingcost(Double shippingcost) {
		this.shippingcost = shippingcost;
	}
}
