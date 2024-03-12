package kr.co.ch07.repository.shop;

import kr.co.ch07.entity.shop.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
