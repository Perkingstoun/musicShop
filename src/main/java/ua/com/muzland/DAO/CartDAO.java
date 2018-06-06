package ua.com.muzland.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.muzland.Entity.Cart;

public interface CartDAO extends JpaRepository<Cart,Integer> {
}
