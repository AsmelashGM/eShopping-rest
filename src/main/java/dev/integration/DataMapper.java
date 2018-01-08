package dev.integration;

import java.util.HashMap;
import java.util.Map;

import dev.model.Administrator;
import dev.model.Customer;
import dev.model.Order;
import dev.model.Product;
import dev.model.ShippingInfo;
import dev.model.ShoppingCart;
import dev.model.User;

public class DataMapper {
	private static Map<String, Product> products = new HashMap<>();
	private static Map<String, User> users = new HashMap<>();
	private static Map<String, Order> orders = new HashMap<>();
	private static Map<String, Customer> customers = new HashMap<>();
	private static Map<String, ShippingInfo> shippingInfo = new HashMap<>();
	private static Map<String, ShoppingCart> shoppingCarts = new HashMap<>();
	private static Map<String, Administrator> administrators = new HashMap<>();
	
	public DataMapper() {

	}
	
	public static Map<String, Product> getProducts() {
		return products;
	}
	public static void setProducts(Map<String, Product> products) {
		DataMapper.products = products;
	}
	public static Map<String, User> getUsers() {
		return users;
	}
	public static void setUsers(Map<String, User> users) {
		DataMapper.users = users;
	}
	public static Map<String, Order> getOrders() {
		return orders;
	}
	public static void setOrders(Map<String, Order> orders) {
		DataMapper.orders = orders;
	}
	public static Map<String, Customer> getCustomers() {
		return customers;
	}
	public static void setCustomers(Map<String, Customer> customers) {
		DataMapper.customers = customers;
	}
	public static Map<String, ShippingInfo> getShippingInfo() {
		return shippingInfo;
	}
	public static void setShippingInfo(Map<String, ShippingInfo> shippingInfo) {
		DataMapper.shippingInfo = shippingInfo;
	}
	public static Map<String, ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}
	public static void setShoppingCarts(Map<String, ShoppingCart> shoppingCarts) {
		DataMapper.shoppingCarts = shoppingCarts;
	}
	public static Map<String, Administrator> getAdministrators() {
		return administrators;
	}
	public static void setAdministrators(Map<String, Administrator> administrators) {
		DataMapper.administrators = administrators;
	}
}
