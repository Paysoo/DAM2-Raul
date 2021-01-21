package M3.UF5.NF4.Activitat16.StoreTester;

class Book extends GoodAbstract implements Taxable {
	private String author;

	public Book(String des, double pr, String auth, int quantity) {
		super(des, pr, quantity);
		author  = auth ;
	}

	public void display() {
		super.display() ;
	    System.out.println( ", author: " + author + ", tax: " + calculateTax());
	}

	public double calculateTax()
	{
		return getPrice() * taxRate ;
	}

	@Override
	protected String getDescription() {
		return null;
	}
}