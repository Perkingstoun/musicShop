package ua.com.muzland.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.muzland.DAO.CartDAO;
import ua.com.muzland.DAO.UserDAO;
import ua.com.muzland.Entity.Cart;

import ua.com.muzland.Service.CartService;
import ua.com.muzland.Service.UserService;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private UserService userService;


    @Autowired
    private CartDAO cartDAO;

    @Override
    public List<Cart> findByUserName(String usermnme) {
        List<Cart> UserCart = userService.findUserByUserName(usermnme).getCart();

        return UserCart;
    }

    @Override
    public void save(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public Cart findSame(int prodId, String  username) {
        List<Cart> carts = userService.findUserByUserName(username).getCart();
//        System.out.println(carts);
        Iterator<Cart> cartIterator = carts.iterator();
        Cart cart;
        System.out.println("service cart");
        while(cartIterator.hasNext()){
            cart = cartIterator.next();
            System.out.println("cicle");
           System.out.println(cart);
            System.out.println(prodId);
            int prodId1 = cart.getProdId();
            System.out.println(prodId1);
            System.out.println(prodId);
            if (prodId1 == prodId){
                System.out.println("same service");
                System.out.println(cart);
                return cart;
            }

        }
        return null;
    }
}
