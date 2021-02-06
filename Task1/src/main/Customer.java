package main;


public class Customer {

    private short values;

    public Customer(String line) {
        String[] customer = line.split("\n");
        values = Short.parseShort(customer[0]);
    }
    public short getValues() {
        return values;
    }
}
