package org.design.shoppingcard;

import java.util.List;

public class CompositeTaxStrategy implements TaxStrategy {
	List<TaxStrategy> listOfStrategies;

	public CompositeTaxStrategy(List<TaxStrategy> strategies) {
		this.listOfStrategies = strategies;
	}

	@Override
	public double calculateTax(Item item) {
		return listOfStrategies.stream().mapToDouble(s -> s.calculateTax(item)).sum();
	}

}
