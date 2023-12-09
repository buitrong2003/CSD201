/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import model.Order;

/**
 *
 * @author d
 */
public class Manage {

    public ArrayList<Fruit> listFruit;
    public Hashtable<String, ArrayList<Order>> listOrder;

    public Manage() {
        listFruit = new ArrayList<>();
        listOrder = new Hashtable<>();
        listFruit.add(new Fruit("1", "Xoai", 12, 100, "VN"));
        listFruit.add(new Fruit("2", "Cam", 12, 100, "VN"));
        listFruit.add(new Fruit("3", "chuoi", 11, 50, "TQ"));
    }

    public Fruit getFruitByID(String id) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void addFruit(Fruit fruit) {
        listFruit.add(fruit);
    }

    public void displayFruit() {
        int countItem = 1;
        for (Fruit fruit : listFruit) {
            System.out.printf("    %-10d", countItem);
            fruit.displayFruit();
            countItem++;
        }
    }

    public Fruit getFruitByItem(int choice) {
        for (int i = 0; i < listFruit.size(); i++) {
            if (choice - 1 == i) {
                return listFruit.get(i);
            }
        }
        return null;
    }

    public Order checkFruitOrder(ArrayList<Order> orders, String id) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(id)) {
                return order;
            }
        }
        return null;
    }

    public void displayListOrder(ArrayList<Order> orders) {
        double total = 0;
        for (Order order : orders) {
            System.out.printf("%-15s%-15d%2.0f$%9.0f$\n", order.getName(), order.getQuantity(),
                    order.getPrice(), order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total + "$");
    }

    public String setName() {
        int count = 0;
        String name = Validation.getString("Input your name: ", "[a-zA-Z ]+",
                "Name must be String.");
        for (String realName : listOrder.keySet()) {
            if (name.equalsIgnoreCase(realName.split("#")[0])) {
                count++;
            }
        }
        return name + "#" + count;
    }
}
