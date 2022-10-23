package com.esprit.order.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.order.Services.IOrderService;
import com.esprit.order.entities.Order;



@RestController
public class OrderController {
	@Autowired
	IOrderService achatService;
	
	//http://localhost:8080/SpringMVC/servlet/allOrder
	//@CrossOrigin(origins ="*")
	@GetMapping("/allOrder")
	@ResponseBody
	public List<Order> getOrder(){
		List<Order> l=achatService.retrieveAllOrder();
		return l;
	}
	
	@PostMapping("/addOrder")
	@ResponseBody
	public Order addAchat(@RequestBody Order a) {
		return achatService.addOrder(a);
	}
	
	@PostMapping("/deleteOrder")
	@ResponseBody
	public void deleteAchat(@RequestBody Order a) {
		achatService.deleteOrder(a);
	}

	@GetMapping("/getOrder/{id}")
	@ResponseBody
	public Optional<Order> getUser(@PathVariable(value = "id")int id){
		Optional<Order> a=achatService.retrieveOrder(id);
		return a;
	}
	
	@PostMapping("/updateOrder")
	@ResponseBody
	public Order updateAchat(@RequestBody Order a) {
		return achatService.updateOrder(a);
	}
	
		
}
