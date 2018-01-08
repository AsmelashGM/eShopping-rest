package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.Order;

public class OrderController {
	private static Map<String, Order> orders = DataMapper.getOrders();
	public OrderController (){
		orders.put(String.valueOf(1L), new Order(1L, "07-01-2018", "07-01-2018", "asm", 1, "Pending", 3L, 2, 450.00));
		orders.put(String.valueOf(2L), new Order(2L, "07-01-2018", "07-01-2018", "guest", 2, "Delivered", 4L, 3, 1035.00));
		orders.put(String.valueOf(3L), new Order(3L, "07-01-2018", "07-01-2018", "tes", 3, "Packed", 5L, 5, 1725.00));
	}
	
	public List<Order> getAllOrders(){
		List<Order> list = new ArrayList<>(orders.values());
		return list;
	}
	
	public List<Order> getAllOrders(String q){
		List<Order> list = new ArrayList<>();
		q = q.toLowerCase();
		for(Order order: orders.values()) {
			if(order.getStatus().toLowerCase().contains(q) || order.getCustomerid().toLowerCase().contains(q)) {
				list.add(order);
			}
		}
		return list;
	}
	
	public List<Order> getAllOrders(int start, int size){
		List<Order> list = new ArrayList<>(orders.values());
		if(start > list.size() - 1)
			return new ArrayList<Order>();
		else if(start + size > list.size())
			return list.subList(start, list.size());
		else
			return list.subList(start, start + size);
	}
	
	public Order getOrder(long id) {
		return orders.get(String.valueOf(id));
	}
	
	public String addOrder(Order order) {
		order.setId(orders.size() + 1);
		orders.put(String.valueOf(order.getId()), order);
		return "Order successfully added!";
	}
	
	public String updateOrder(Order order) {
		if(order.getId() <= 0) {
			return "Order is not updated!";
		}
		orders.put(String.valueOf(order.getId()), order);
		return "Order successfully updated!";
	}
	
	public String removeOrder(long id) {
		orders.remove(String.valueOf(id));
		return "Order successfully removed!";
	}
}