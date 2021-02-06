package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


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

        ArrayList<Short> customersGeneral = new ArrayList<>();

        for (int i = 0; i<customers.size(); i++) {
            Customer customer = customers.get(i);
            customersGeneral.add((short) customer.getValues());
        }
        Collections.sort(customersGeneral);

        Calculations percentile90 = new Calculations();
        percentile90.percentile(customersGeneral, 90);

        Calculations median = new Calculations();
        median.percentile(customersGeneral, 50);

        System.out.println(String.format("%.2f", (float)(customersGeneral.get(customersGeneral.size() - 1))));

        System.out.println(String.format("%.2f", (float)(customersGeneral.get(0))));

        Calculations mean = new Calculations();
        mean.mean(customersGeneral);

    }
}