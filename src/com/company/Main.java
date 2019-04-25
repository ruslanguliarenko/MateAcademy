package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) {

        String expr = "";
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            expr = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Calculator calculator = new Calculator(expr);
        System.out.println(calculator.getResult());

    }

}
