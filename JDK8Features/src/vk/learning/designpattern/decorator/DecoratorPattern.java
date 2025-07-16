package vk.learning.designpattern.decorator;

interface Dress {
	void assemble();
}

class BasicDress implements Dress {

	@Override
	public void assemble() {
		System.out.println("Basic Dress");
	}
}

class DressDecorator implements Dress {
	Dress dress;

	public DressDecorator(Dress dress) {
		this.dress = dress;
	}

	@Override
	public void assemble() {
		dress.assemble();
	}
}

class CasualDress extends DressDecorator {

	public CasualDress(Dress dress) {
		super(dress);
	}

	public void assemble() {
		super.assemble();
		System.out.println("Adding casual dress feature");
	}
}

class SportyDress extends DressDecorator {

	public SportyDress(Dress dress) {
		super(dress);
	}

	public void assemble() {
		super.assemble();
		System.out.println("Adding SportyDress dress feature");
	}
}

class FancyDress extends DressDecorator {

	public FancyDress(Dress dress) {
		super(dress);
	}

	public void assemble() {
		super.assemble();
		System.out.println("Adding FancyDress dress feature");
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		Dress sportsdress = new SportyDress(new BasicDress());
		sportsdress.assemble();
		System.out.println("------------");
		Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
		sportyFancyDress.assemble();
	}
}
