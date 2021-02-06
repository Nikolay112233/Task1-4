package main;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        File file1 = new File(args[0]);
        ArrayList<Customer> customer1 = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file1)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customer1.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral1 = new ArrayList<>();

        for (int i = 0; i<customer1.size(); i++) {
            Customer customer = customer1.get(i);
            customersGeneral1.add((double) customer.getValues());
        }

        File file2 = new File(args[1]);
        ArrayList<Customer> customer2 = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file2)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[1]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customer2.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral2 = new ArrayList<>();

        for (int i = 0; i<customer2.size(); i++) {
            Customer customer = customer2.get(i);
            customersGeneral2.add((double) customer.getValues());
        }

        File file3 = new File(args[2]);
        ArrayList<Customer> customer3 = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file3)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[2]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customer3.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral3 = new ArrayList<>();

        for (int i = 0; i<customer3.size(); i++) {
            Customer customer = customer3.get(i);
            customersGeneral3.add((double) customer.getValues());
        }

        File file4 = new File(args[3]);
        ArrayList<Customer> customer4 = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file4)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[3]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customer4.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral4 = new ArrayList<>();

        for (int i = 0; i<customer4.size(); i++) {
            Customer customer = customer4.get(i);
            customersGeneral4.add((double) customer.getValues());
        }

        File file5 = new File(args[4]);
        ArrayList<Customer> customer5 = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(file5)) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[4]));
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                customer5.add(new Customer(currentLine));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Double> customersGeneral5 = new ArrayList<>();

        for (int i = 0; i<customer5.size(); i++) {
            Customer customer = customer5.get(i);
            customersGeneral5.add((double) customer.getValues());
        }

        ArrayList<Double> allCashDeck = new ArrayList<>();
        for (int i = 0; i < customersGeneral1.size(); i++) {
            allCashDeck.add(customersGeneral1.get(i) + customersGeneral2.get(i) + customersGeneral3.get(i) + customersGeneral4.get(i)+ customersGeneral5.get(i));
        }

        int maxTurn = 0;
        for (int i = 1; i < allCashDeck.size(); i++) {
            if (allCashDeck.get(i) > allCashDeck.get(maxTurn)) {
                maxTurn = i;
            }
        }
        System.out.println(maxTurn + 1);
    }
}