package M3.UF5.NF4.Activitat16.StoreTester;

public abstract class GoodAbstract {
    private String description;
    private double price;
    private int quantity;

    public GoodAbstract(String description, double price,
                        int quantity){
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    protected double getPrice() {
        return this.price;
    }
    protected void setPrice(double newPrice) {
        this.price = newPrice;
    }
    protected int getQuantity() {
        return this.quantity;
    }
    protected void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public String toString() {
        return "item: " + getDescription() + " quantity: " +
                getQuantity() + " price: " + getPrice();
    }

    protected abstract String getDescription();

    protected void display() {
        System.out.println("Cantidad: " + getQuantity() + "\nPrecio: "
                + getPrice() + "\nDescripcion: " + getDescription());
    }
}