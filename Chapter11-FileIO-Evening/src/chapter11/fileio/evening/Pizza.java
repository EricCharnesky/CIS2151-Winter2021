package chapter11.fileio.evening;

import java.io.Serializable;
import java.util.ArrayList;

public class Pizza implements Serializable {

    private String size;
    private String style;
    private ArrayList<String> toppings;
    private double price;

    public Pizza(String size, String style, ArrayList<String> toppings, double price) {
        this.size = size;
        this.style = style;
        this.toppings = toppings;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public String getStyle() {
        return style;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public double getPrice() {
        return price;
    }

}
