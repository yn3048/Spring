package kr.co.ch07.repository.shop;

import kr.co.ch07.entity.shop.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
