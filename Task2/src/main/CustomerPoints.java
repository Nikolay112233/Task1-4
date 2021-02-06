package main;

import java.util.regex.Pattern;

public class CustomerPoints {

    private String valuesPointsX;
    private String valuesPointsY;

    public CustomerPoints(String line) {
        Pattern pat = Pattern.compile("[\n ]");
        String[] customerPoints = pat.split(line);
        valuesPointsX = customerPoints[0];
        valuesPointsY = customerPoints[1];
    }
    public String getValuesPointsX() {
        return valuesPointsX;
    }
    public String getValuesPointsY() {
        return valuesPointsY;
    }
}
