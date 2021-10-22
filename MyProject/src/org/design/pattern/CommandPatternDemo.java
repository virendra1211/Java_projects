package org.design.pattern;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternDemo {
	public static void main(String[] args) {
		Stock abcStock = new Stock("idea ",200);

	      BuyStock buyStockOrder = new BuyStock(abcStock);
	      SellStock sellStockOrder = new SellStock(abcStock);

	      Broker broker = new Broker();
	      broker.takeOrder(buyStockOrder);
	      broker.takeOrder(sellStockOrder);

	      broker.placeOrders();
	}
}

interface Order {
	public void execute();
}

class Stock {
	private String name;
	private Integer quantity;
	
	Stock(String name,Integer quantity){
		this.name = name;
		this.quantity = quantity;
	}
	public void buy() {
		System.out.println("Buy Stock " +name+" quantity "+quantity);
	}
	
	public void sell() {
		System.out.println("Sell Stock " +name+" quantity "+quantity);
	}
}

class BuyStock implements Order{

	private Stock stock;
	BuyStock(Stock stock){
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.buy();
	}
}

class SellStock implements Order{

	private Stock stock;
	SellStock(Stock stock){
		this.stock = stock;
	}
	@Override
	public void execute() {
		stock.sell();
	}
}

class Broker {
	private List<Order> orderList = new ArrayList<Order>();
	
	public void takeOrder(Order order) {
		orderList.add(order);
	}
	public void placeOrders() {
		orderList.forEach((a) -> a.execute());
	
		orderList.clear();
	}
		
}