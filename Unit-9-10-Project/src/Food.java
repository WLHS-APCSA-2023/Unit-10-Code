public class Food extends Product {
    private int calories;

    public Food(String name, double price, int calories, int quantity) {
        super(name, price, quantity);
        this.calories = calories;
    }

    @Override
    public String toString() {
        return super.toString() + ", Calories: " + calories;
    }
}