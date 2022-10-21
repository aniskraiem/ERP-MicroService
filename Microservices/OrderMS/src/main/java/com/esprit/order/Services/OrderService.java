package com.esprit.order.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.order.Repository.OrderRepository;
import com.esprit.order.entities.Order;



@Service
public class OrderService implements IOrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> retrieveAllOrder() {
		List <Order> al =(List<Order>) orderRepository.findAll();
		return al;
	}

	@Override
	public Order addOrder(Order a) {
		return (Order) orderRepository.save(a);
	}

	@Override
	public void deleteOrder(Order a) {
		orderRepository.deleteById(a.getId());

	}

	@Override
	public Order updateOrder(Order a) {
		Order al = (Order) orderRepository.save(a);
		return al;
	}

	@Override
	public Optional<Order> retrieveOrder(int id) {
		Optional<Order> a=orderRepository.findById(id);
		return a;
	}

}
