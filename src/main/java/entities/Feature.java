package entities;

public class Feature extends Entity{
    private final String name;
    private final double price;
    private final String description;

    public Feature(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String getEntityStr() {
        return "Name: " + this.name + ", Description: " + this.description;
    }
}
