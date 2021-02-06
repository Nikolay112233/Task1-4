package main;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[0]);
        ArrayList<Customer> customers = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customers.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            Customer customer2 = customers.get(i);
            customersGeneral.add((Double.parseDouble(customer.getValuesX())));
            customersGeneral.add((Double.parseDouble(customer.getValuesY())));
        }

        File filePoints = new File(args[1]);
        ArrayList<CustomerPoints> customersPoints = new ArrayList<>();
        try (InputStream inputStreamPoints = new FileInputStream(file)) {
            BufferedReader bufferedReaderPoints = new BufferedReader(new FileReader(args[1]));
            String currentLinePoints;
            while ((currentLinePoints = bufferedReaderPoints.readLine()) != null) {
                customersPoints.add(new CustomerPoints(currentLinePoints));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersPointsGeneral = new ArrayList<>();

        for (int i = 0; i < customersPoints.size(); i++) {
            CustomerPoints customerPoints = customersPoints.get(i);
            CustomerPoints customerPoints2 = customersPoints.get(i);
            customersPointsGeneral.add((Double.parseDouble(customerPoints.getValuesPointsX())));
            customersPointsGeneral.add((Double.parseDouble(customerPoints2.getValuesPointsY())));
        }

        int result = 0;
        double x = 0.0;
        double y = 0.0;
        double leftSide = 0.0;
        double rightSide = 0.0;
        double topSide = 0.0;
        double bottomSide = 0.0;
        double d = (customersGeneral.get(6) - customersGeneral.get(0)) * (customersGeneral.get(3) - customersGeneral.get(1)) - (customersGeneral.get(2) - customersGeneral.get(0)) * (customersGeneral.get(7) - customersGeneral.get(1));
        for (int i = 0; i < customersPointsGeneral.size(); i += 2) {
            x = ((customersGeneral.get(3) - customersGeneral.get(1)) * (customersPointsGeneral.get(i) - customersGeneral.get(0)) - (customersGeneral.get(2) - customersGeneral.get(0)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(1)))/d;
            y = ((-(customersGeneral.get(7) - customersGeneral.get(1)) * (customersPointsGeneral.get(i) - customersGeneral.get(0))) + ((customersGeneral.get(6) - customersGeneral.get(0)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(1))))/d;
            leftSide = (customersGeneral.get(0) - customersGeneral.get(2)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(3)) - (customersPointsGeneral.get(i) - customersGeneral.get(2)) * (customersGeneral.get(1) - customersGeneral.get(3));
            rightSide = (customersGeneral.get(4) - customersGeneral.get(6)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(7)) - (customersPointsGeneral.get(i) - customersGeneral.get(6)) * (customersGeneral.get(5) - customersGeneral.get(7));
            topSide = (customersGeneral.get(2) - customersGeneral.get(4)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(5)) - (customersPointsGeneral.get(i) - customersGeneral.get(4)) * (customersGeneral.get(3) - customersGeneral.get(5));
            bottomSide = (customersGeneral.get(6) - customersGeneral.get(0)) * (customersPointsGeneral.get(i + 1) - customersGeneral.get(1)) - (customersPointsGeneral.get(i) - customersGeneral.get(0)) * (customersGeneral.get(7) - customersGeneral.get(1));

            if (x > 0 && x < 1 && y > 0 && y < 1) {
                result = 2;
            } else if (leftSide == 0 && customersGeneral.get(1) <= customersPointsGeneral.get(i + 1) && customersGeneral.get(3) >= customersPointsGeneral.get(i + 1)) {
                result = 1;
            } else if (rightSide == 0 && customersGeneral.get(7) <= customersPointsGeneral.get(i + 1) && customersGeneral.get(5) >= customersPointsGeneral.get(i + 1)) {
                result = 1;
            } else if (topSide == 0 && customersGeneral.get(2) <= customersPointsGeneral.get(i) && customersGeneral.get(4) >= customersPointsGeneral.get(i)) {
                result = 0;
            } else if (bottomSide == 0 && customersGeneral.get(0) <= customersPointsGeneral.get(i) && customersGeneral.get(6) >= customersPointsGeneral.get(i)) {
                result = 0;
            } else {
                result = 3;
            }
            System.out.println(result);
        }
    }
}