package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.ShoppingCart;

public class ShoppingCartController {
	private static Map<String, ShoppingCart> shoppingCarts = DataMapper.getShoppingCarts();

	public ShoppingCartController(){
		shoppingCarts.put(String.valueOf(1L), new ShoppingCart(1L, 3L, 2, "08/01/2018"));
		shoppingCarts.put(String.valueOf(2L), new ShoppingCart(2L, 5L, 3, "08/01/2018"));
		shoppingCarts.put(String.valueOf(3L), new ShoppingCart(3L, 6L, 4, "08/01/2018"));
		shoppingCarts.put(String.valueOf(4L), new ShoppingCart(4L, 7L, 6, "08/01/2018"));
	}
	
	public List<ShoppingCart> getAllShoppingCarts(){
		List<ShoppingCart> list = new ArrayList<>(shoppingCarts.values());
		return list;
	}
	
	public List<ShoppingCart> getAllShoppingCarts(int start, int size){
		List<ShoppingCart> list = new ArrayList<>(shoppingCarts.values());
		if(start > list.size() - 1)
			return new ArrayList<ShoppingCart>();
		else if(start + size > list.size())
			return list.subList(start, list.size());
		else
			return list.subList(start, start + size);
	}
	
	public ShoppingCart getShoppingCart(long id) {
		return shoppingCarts.get(String.valueOf(id));
	}
	
	public String addShoppingCart(ShoppingCart shoppingCart) {
		shoppingCart.setId(shoppingCarts.size() + 1);
		shoppingCarts.put(String.valueOf(shoppingCart.getId()), shoppingCart);
		return "Item successfully added!";
	}
	
	public String updateShoppingCart(ShoppingCart shoppingCart) {
		if(shoppingCart.getId() <= 0) {
			return "Item is not updated!";
		}
		shoppingCarts.put(String.valueOf(shoppingCart.getId()), shoppingCart);
		return "Item successfully updated!";
	}
	
	public String removeShoppingCart(long id) {
		shoppingCarts.remove(String.valueOf(id));
		return "Item successfully removed!";
	}
}