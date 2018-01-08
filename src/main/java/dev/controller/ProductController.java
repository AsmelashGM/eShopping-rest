package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.Product;

public class ProductController {
	private static Map<String, Product> products = DataMapper.getProducts();

	public ProductController(){
		products.put(String.valueOf(1L), new Product(
				1L, "Shoe 1", "Men's fine leather match with a trench coat.", 
				"Shoe", "number", 345.90, 10, "shoes1.jpg", 43));
		products.put(String.valueOf(2L), new Product(
				2L, "Shoe 2", "Men's new fishine used during summer seasons", 
				"Shoe", "number", 450.00, 4, "shoes2.jpg", 42));
		products.put(String.valueOf(3L), new Product(
				3L, "Shoe 3", "Summar simple blue-black shoes for men", 
				"Shoe", "number", 345.00, 10, "shoes3.jpg", 40));
		products.put(String.valueOf(4L), new Product(
				4L, "Shoe 4", "Summar simple white-brown shoes for women", 
				"Shoe", "number", 450.00, 4, "shoes4.jpg", 46));
		products.put(String.valueOf(5L), new Product(
				5L, "Shoe 5", "Summar simple blue-black shoes for men", 
				"Shoe", "number", 345.00, 10, "shoes5.jpg", 37));
		products.put(String.valueOf(6L), new Product(
				6L, "Shoe 6", "Summar simple white-brown shoes for women", 
				"Shoe", "number", 450.00, 4, "shoes6.jpg", 40));
		products.put(String.valueOf(7L), new Product(
				7L, "Shoe 7", "Summar simple blue-black shoes for men", 
				"Shoe", "number", 345.00, 10, "shoes7.jpg", 38));
		products.put(String.valueOf(8L), new Product(
				8L, "Shoe 8", "Summar simple white-brown shoes for women", 
				"Shoe", "number", 450.00, 4, "shoes8.jpg", 39));
	}
	
	public List<Product> getAllProducts(){
		List<Product> list = new ArrayList<>(products.values());
		return list;
	}
	
	public List<Product> getAllProducts(String q){
		List<Product> list = new ArrayList<>();
		q = q.toLowerCase();
		for(Product product: products.values()) {
			if(product.getName().toLowerCase().contains(q) || product.getDescription().toLowerCase().contains(q)) {
				list.add(product);
			}
		}
		return list;
	}
	
	public List<Product> getAllProducts(int start, int size){
		List<Product> list = new ArrayList<>(products.values());
		if(start > list.size() - 1)
			return new ArrayList<Product>();
		else if(start + size > list.size())
			return list.subList(start, list.size());
		else
			return list.subList(start, start + size);
	}
	
	public Product getProduct(long id) {
		return products.get(String.valueOf(id));
	}
	
	public String addProduct(Product product) {
		product.setId(products.size() + 1);
		products.put(String.valueOf(product.getId()), product);
		return "Product successfully added!";
	}
	
	public String updateProduct(Product product) {
		if(product.getId() <= 0) {
			return "Product is not updated!";
		}
		products.put(String.valueOf(product.getId()), product);
		return "Product successfully updated!";
	}
	
	public String removeProduct(long id) {
		products.remove(String.valueOf(id));
		return "Product successfully removed!";
	}
}