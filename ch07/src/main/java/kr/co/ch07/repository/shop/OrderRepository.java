package kr.co.ch07.repository.shop;

import kr.co.ch07.entity.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
