package main;

import java.util.regex.Pattern;

public class Customer {

    private String valuesX;
    private String valuesY;

    public Customer(String line) {
        Pattern pat = Pattern.compile("[\n ]");
        String[] customer = pat.split(line);
        valuesX = customer[0];
        valuesY = customer[1];
    }
    public String getValuesX() {
        return valuesX;
    }
    public String getValuesY() {
        return valuesY;
    }
}