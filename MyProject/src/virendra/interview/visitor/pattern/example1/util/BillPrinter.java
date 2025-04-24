package virendra.interview.visitor.pattern.example1.util;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import org.design.pattern.Customer;

import virendra.interview.visitor.pattern.example1.items.ShopItem;

public class BillPrinter {

    public static double calculateAndPrintBill(Customer customer, List<ShopItem> items) {
	double totalCost = printItemisedBill(customer, items);
	System.out.printf("Total Cost = %69.2f\n", totalCost);
	System.out.println(
		"============================================================================================================");
	return totalCost;
    }

    public static double printItemisedBill(Customer customer, List<ShopItem> items) {
	items.sort(Comparator.comparing(ShopItem::getCategory).thenComparing(ShopItem::getName));
	System.out.printf("                                Shopping Items Bill for the %s\n", customer);
	System.out.println(
		"============================================================================================================");
	System.out.printf("%25s | %15s | %10s | %10s | %10s\n", "Shopping Item", "Category", "Price", "Weight", "Cost");
	System.out.println(
		"------------------------------------------------------------------------------------------------------------");
	DoubleAdder totalCost = new DoubleAdder();
	items.stream().forEach(item -> {
	    String name = item.getName();
	    double price = item.getPrice();
	    double weight = item.getWeight();
	    // double cost = customer.calculatePrice(item);
	    // totalCost.add(cost);
	    System.out.printf("%25s | %15s | %10.2f | %10s | %10.2f\n", name, item.getCategory().getName(), price,
		    (weight > 0.0d) ? weight : "-", "");
	});
	System.out.println(
		"============================================================================================================");
	return totalCost.doubleValue();
    }
}
