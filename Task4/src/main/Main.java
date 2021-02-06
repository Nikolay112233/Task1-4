package main;

import java.io.*;
import java.text.DecimalFormat;
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

        ArrayList<String> customersGeneral = new ArrayList<>();

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            customersGeneral.add(customer.getValues1());
            customersGeneral.add(customer.getValues2());
        }

        ArrayList<Integer> timeArrival = new ArrayList<>();
        ArrayList<Integer> timeExit = new ArrayList<>();
        Integer[] fullTime = new Integer[720];
        Integer[] timeEquals = new Integer[720];
        for (int i = 0; i < fullTime.length; i++) {
            fullTime[i] = 0;
            timeEquals[i] = i;
        }

        for (int i = 0; i < customersGeneral.size(); i += 2) {
            String s = customersGeneral.get(i);
            String[] numbers = (s.length() <= 3 ? s + ":00" : s).split(":");
            int hh = (Integer.valueOf(numbers[0]) - 8) * 60;
            int mm = Integer.valueOf(numbers[1]);
            timeArrival.add(hh + mm);

            s = customersGeneral.get(i + 1);
            numbers = (s.length() <= 3 ? s + ":00" : s).split(":");
            hh = (Integer.valueOf(numbers[0]) - 8) * 60;
            mm = Integer.valueOf(numbers[1]);
            timeExit.add(hh + mm);
        }

        for (int i = 0; i < fullTime.length; i++) {
            for (int j = 0; j < timeArrival.size(); j++) {
                if (timeEquals[i].equals(timeArrival.get(j))) {
                    for (int x = i; x < fullTime.length; x++) {
                        fullTime[x] = fullTime[x] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < fullTime.length; i++) {
            for (int j = 0; j < timeExit.size(); j++) {
                if (timeEquals[i].equals(timeExit.get(j))) {
                    for (int x = i; x < fullTime.length; x++) {
                        fullTime[x] = fullTime[x] - 1;
                    }
                }
            }
        }
        ArrayList<Integer> resultMin = new ArrayList<>();
        int resultValue = 0;
        for (int i = 1; i < fullTime.length; i++) {
            if (fullTime[i] > fullTime[resultValue]) {
                resultMin.clear();
                resultValue = i;
                resultMin.add(i);
            } else if (fullTime[i] == fullTime[resultValue]) {
                resultMin.add(i);
            }
        }

        DecimalFormat f = new DecimalFormat("#,##00");
        ArrayList<String> timeOn = new ArrayList<>();
        ArrayList<String> timeOff = new ArrayList<>();

        System.out.print(((resultMin.get(0) / 60) + 8) + ":" + f.format(resultMin.get(0) % 60) + " ");

        for (int i = 1; i < resultMin.size() - 1; i++) {
            if (resultMin.get(i) < (resultMin.get(i + 1) - 1)) {
                timeOff.add((((resultMin.get(i) + 1) / 60) + 8) + ":" + (f.format((resultMin.get(i) + 1) % 60)) + "\n");
                timeOn.add((((resultMin.get(i + 1)) / 60) + 8) + ":" + (f.format((resultMin.get(i + 1)) % 60)) + " ");
            }
        }
        for (int i = 0; i < timeOff.size(); i++) {
            System.out.print(timeOff.get(i));
            System.out.print(timeOn.get(i));
        }
        System.out.print((((resultMin.get(resultMin.size() - 1) + 1) / 60) + 8) + ":" + f.format((resultMin.get(resultMin.size() - 1) + 1) % 60));

    }
}
