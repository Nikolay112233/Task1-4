package main;


public class Customer {

    private double values;

    public Customer(String line) {
        String[] customer = line.split("\n");
        values = Double.parseDouble(customer[0]);
    }
    public double getValues() {
        return values;
    }
}