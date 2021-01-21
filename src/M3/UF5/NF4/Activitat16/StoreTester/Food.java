package M3.UF5.NF4.Activitat16.StoreTester;

class Food extends GoodAbstract {

	private double calories;

	public Food(String des, double pr, double cal, int quantity) {
		super( des, pr, quantity );
		calories = cal ;
	}

	public void display() {
		super.display( );
		System.out.println( ", calories: " + calories );
	}

	@Override
	protected String getDescription() {
		return null;
	}
}