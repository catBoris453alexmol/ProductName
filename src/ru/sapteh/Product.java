package ru.sapteh;

public class Product {
    private int id;
    private String name;
    private String price;
    private String quantity;

    public Product (int id, String name, String price, String quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }
    @Override
    public String toString(){
        return String.format("%-8d %-30s %-8s %-4s", id,name, price,quantity);
    }
}
