package ua.com.muzland.Service;

import ua.com.muzland.Entity.Cart;

import java.util.List;

public interface CartService {

    void save(Cart cart);
    List<Cart> findByUserName(String username);
    Cart findSame(int prodId, String username);
}
