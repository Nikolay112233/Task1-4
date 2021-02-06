package main;

import java.util.ArrayList;

public class Calculations {

    private float overF;
    private float underF;
    private int valueF;
    private float result;
    private float sum = 0;


    public float getResult() {
        return result;
    }

    public void percentile (ArrayList list, int fi) {
        valueF = (list.size() * fi)/100;
        underF = ((float)(fi/100f) * (short)(list.get(valueF - 1)));
        overF = ((float)(1 - fi/100f) * (short)(list.get(valueF)));
        result = underF + overF;
        System.out.println(String.format("%.2f", getResult()));
    }

    public void mean (ArrayList list) {
        for (int i = 0; i < list.size(); i++) {
            sum = (short) (sum + (short) list.get(i));
        }
        result = (float) sum / (float) list.size();
        System.out.println(String.format("%.2f", getResult()));
    }

}
