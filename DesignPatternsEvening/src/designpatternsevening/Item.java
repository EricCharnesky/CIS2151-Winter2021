/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatternsevening;


public class Item {
    private double price;
    private double taxRate;
    private String name;

    public Item(double price, double taxRate, String name) {
        this.price = price;
        this.taxRate = taxRate;
        this.name = name;
    }
    
    public double getTotalPrice(){
        return price + price * taxRate;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public String getName() {
        return name;
    }
    
    
    

}
