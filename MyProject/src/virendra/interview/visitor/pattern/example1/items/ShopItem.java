package virendra.interview.visitor.pattern.example1.items;

public interface ShopItem {

	String getName();

	double getPrice();

	double getWeight();

	ShopItemCategory getCategory();
}
