/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import controller.Validation;
import java.util.ArrayList;
import model.Fruit;
import model.Order;

/**
 *
 * @author d
 */
public class ViewFruit {

    Manage manage = new Manage();

    void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1.	Create Fruit\n"
                + "2.	View orders\n"
                + "3.	Shopping (for buyer)\n"
                + "4.	Exit");
    }

    void createFruit() {
        System.out.println("-------- Create Fruit --------");
        while (true) {
            String id = Validation.getString("Enter ID fruit: ", "[a-zA-Z0-9 ]+",
                    "ID must be String.");
            if (manage.getFruitByID(id) != null) {
                System.err.println("ID of fruit Duplicate.");
                continue;
            }
            String name = Validation.getString("Enter Name fruit: ", "[a-zA-Z ]+",
                    "Name must be String.");
            double price = Validation.getDouble("Enter Price fruit: ", 1, Double.MAX_VALUE, "Price must be Double");
            int quantity = Validation.getInteger("Enter Quantity fruit: ", 1,
                    Integer.MAX_VALUE, "Quantity must be Double.");
            String origin = Validation.getString("Enter Origin fruit: ", "[a-zA-Z ]+",
                    "Origin must be String.");
            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            manage.addFruit(fruit);
            System.out.println("Add successfully.");
            if (!Validation.checkInputYN("Do you want to continue (Y/N)? (Y/N): ",
                    "Input must be y/Y or n/N.")) {
                break;
            }
        }
    }

    void viewOrder() {
        System.out.println("-------- View orders --------");
        if (manage.listOrder.isEmpty()) {
            System.out.println("List Order Empty.");
        } else {
            for (String name : manage.listOrder.keySet()) {
                System.out.println("Customer: " + name.split("#")[0]);
                System.out.printf("%-15s%-15s%-8s%-10s\n", "Product", "Quantity", "Price", "Amount");
                manage.displayListOrder(manage.listOrder.get(name));
            }
        }
    }

    void shopping() {
        System.out.println("-------- Shopping (for buyer) --------");
        if (manage.listFruit.isEmpty()) {
            System.out.println("List Fruit Empty.");
        } else {
            ArrayList<Order> orders = new ArrayList<>();
            while (true) {
                System.out.printf("| %-10s | %-16s | %-12s | %-11s |\n", "++ Item ++ ", "++ Fruit Name ++ ",
                        "++ Origin ++ ", "++ Price ++ ");
                manage.displayFruit();
                int choice = Validation.getInteger("Enter Item: ", 1, manage.listFruit.size(),
                        "Choice must be number Integer.");
                Fruit fruit = manage.getFruitByItem(choice);
                System.out.println("You selected: " + fruit.getName());
                int quantity = Validation.getInteger("Please input quantity: ", 0,
                        fruit.getQuantity(), "Quantity must be Integer.");
                fruit.setQuantity(fruit.getQuantity() - quantity);
                if (quantity != 0) {
                    Order fruitOrder = manage.checkFruitOrder(orders, fruit.getId());
                    if (fruitOrder != null) {
                        fruitOrder.setQuantity(quantity + fruitOrder.getQuantity());
                    } else {
                        Order order = new Order(fruit.getId(), fruit.getName(),
                                quantity, fruit.getPrice());
                        orders.add(order);
                    }
                }
                if (fruit.getQuantity() == 0) {
                    manage.listFruit.remove(fruit);
                }
                if (manage.listFruit.isEmpty()) {
                    System.out.println("The list fruit is out of stock, please pay now.");
                    break;
                }
                if (Validation.checkInputYN("Do you want to order now (Y/N)? (Y/N): ",
                        "Input must be y/Y or n/N.")) {
                    break;
                }
            }
            if (orders.isEmpty()) {
                System.out.println("No order.");
            } else {
                System.out.printf("%-15s%-15s%-8s%-10s\n", "Product", "Quantity", "Price", "Amount");
                manage.displayListOrder(orders);
                String name = manage.setName();
                manage.listOrder.put(name, orders);
                System.out.println("Order Successfully.");
            }
        }
    }
}
