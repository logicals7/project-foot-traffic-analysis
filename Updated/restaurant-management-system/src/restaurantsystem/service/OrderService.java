/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem.service;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import restaurantsystem.model.Cart;
import restaurantsystem.model.CartItem;
import restaurantsystem.model.Order;


public class OrderService {
    
    private Cart cart;
    
    public OrderService() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public List<Order> getAll() {
        List<Order> items = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("storage/order.txt"))) {
            while (scanner.hasNextLine()) {
                String itemLine = scanner.nextLine();

                String itemInfo[] = itemLine.split(",");

                Order item = new Order(Integer.parseInt(itemInfo[0]), Double.parseDouble(itemInfo[1]),
                        (itemInfo[2]));

                items.add(item);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }
    
    public void addToCart(CartItem cartItem) {
        this.cart.addItemToCart(cartItem);
    }
    
    public void clearCart() {
        this.cart = new Cart(new ArrayList<>(), 0);
    }
    
    public Cart getCart() {
        return this.cart;
    }
}
