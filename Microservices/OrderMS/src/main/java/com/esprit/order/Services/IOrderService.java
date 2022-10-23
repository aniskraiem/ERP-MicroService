package com.esprit.order.Services;
import java.util.List;
import java.util.Optional;

import com.esprit.order.entities.Order;



public interface IOrderService {
	List<Order> retrieveAllOrder();
	Order addOrder(Order a);
	void deleteOrder(Order a);
	Order updateOrder(Order a);
	Optional<Order> retrieveOrder(int id);
}
