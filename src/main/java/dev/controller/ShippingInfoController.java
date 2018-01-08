package dev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dev.integration.DataMapper;
import dev.model.ShippingInfo;

public class ShippingInfoController {
	private static Map<String, ShippingInfo> shippingDetails = DataMapper.getShippingInfo();

	public ShippingInfoController(){
		shippingDetails.put(String.valueOf(1L), new ShippingInfo(1L, "Marin", 23.0));
		shippingDetails.put(String.valueOf(2L), new ShippingInfo(2L, "Cargo", 12.0));
		shippingDetails.put(String.valueOf(3L), new ShippingInfo(3L, "Post", 18.0));
		shippingDetails.put(String.valueOf(4L), new ShippingInfo(4L, "Car", 0.0));
	}
	
	public List<ShippingInfo> getAllShippingInfos(){
		List<ShippingInfo> list = new ArrayList<>(shippingDetails.values());
		return list;
	}
	
	public List<ShippingInfo> getAllShippingInfos(String q){
		List<ShippingInfo> list = new ArrayList<>();
		q = q.toLowerCase();
		for(ShippingInfo shipingInfo: shippingDetails.values()) {
			if(shipingInfo.getShippingtype().toLowerCase().contains(q)) {
				list.add(shipingInfo);
			}
		}
		return list;
	}
	
	public List<ShippingInfo> getAllShippingInfos(int start, int size){
		List<ShippingInfo> list = new ArrayList<>(shippingDetails.values());
		if(start > list.size() - 1)
			return new ArrayList<ShippingInfo>();
		else if(start + size > list.size())
			return list.subList(start, list.size());
		else
			return list.subList(start, start + size);
	}
	
	public ShippingInfo getShippingInfo(long id) {
		return shippingDetails.get(String.valueOf(id));
	}
	
	public String addShippingInfo(ShippingInfo shipingInfo) {
		shipingInfo.setId(shippingDetails.size() + 1);
		shippingDetails.put(String.valueOf(shipingInfo.getId()), shipingInfo);
		return "ShippingInfo successfully added!";
	}
	
	public String updateShippingInfo(ShippingInfo shipingInfo) {
		if(shipingInfo.getId() <= 0) {
			return "ShippingInfo is not updated!";
		}
		shippingDetails.put(String.valueOf(shipingInfo.getId()), shipingInfo);
		return "ShippingInfo successfully updated!";
	}
	
	public String removeShippingInfo(long id) {
		shippingDetails.remove(String.valueOf(id));
		return "ShippingInfo successfully removed!";
	}
}