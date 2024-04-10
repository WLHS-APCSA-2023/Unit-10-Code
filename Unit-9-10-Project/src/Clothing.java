public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, String size, int quantity) {
        super(name, price, quantity);
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + ", Size: " + size;
    }
}