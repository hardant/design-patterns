package com.brandon.designPattern._16_command;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CommandDemo {
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();

        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}

class Stock {
    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println(String.format("Stock [ Name: %s, Quantity: %d ] bought", name, quantity));
    }

    public void sell() {
        System.out.println(String.format("Stock [ Name: %s, Quantity: %d ] sold", name, quantity));
    }
}

interface Order {
    void execute();
}

class BuyStock implements Order {
    private final Stock stock;

    BuyStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();
    }
}

class SellStock implements Order {
    private final Stock stock;

    SellStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();
    }
}

class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        this.orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }

        orderList.clear();
    }
}
