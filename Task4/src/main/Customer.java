package main;

import java.util.regex.Pattern;

public class Customer {

    private String values1;
    private String values2;

    public Customer(String line) {
        Pattern pat = Pattern.compile("[ \n]");
        String[] customer = pat.split(line);
        values1 = customer[0];
        values2 = customer[1];
    }
    public String getValues1() {
        return values1;
    }
    public String getValues2() {
        return values2;
    }

}