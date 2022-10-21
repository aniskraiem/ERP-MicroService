package com.esprit.order.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.order.entities.Order;




@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

}
