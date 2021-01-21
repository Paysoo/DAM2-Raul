package M3.UF5.NF4.Activitat16.StoreTester;

class Toy extends GoodAbstract implements Taxable {
	private int minimumAge;

	public Toy(String des, double pr, int min, int quantity) {
	    super(des, pr, quantity);
	    minimumAge  = min ;
	}

	public void display()  {
		super.display() ;
		System.out.println( ", minimum age: " + minimumAge + ", tax: " + calculateTax());
	}
	
	public double calculateTax() {
		return getPrice() * taxRate ;
	}

	@Override
	protected String getDescription() {
		return null;
	}
}