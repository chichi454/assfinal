public class Book {

    // attributes id, name, price
    int id;
    String name;
    double price;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    // constructor
    public Book(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * return this as a String in the required format
     */
    @Override
    public String toString() {
        return String.format("%5d %-45s %10.2f", id, name, price);
    }
}
