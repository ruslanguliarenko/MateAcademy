package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Calculator {
    private  List<Number> numbers = new ArrayList<>();
    private  TreeSet<Operation> operations = new TreeSet<>();
    private String exp;

    public Calculator(String exp){

        this.exp = exp;
    }

    public String getResult(){
        formOrderOfOperations(exp);
        for(Number o : numbers){
            if(!o.getType().equals(numbers.get(0).getType()) || o.getType().equals("N"))
                return "Вираз не валідний!!!";
        }
        while (operations.size()>0){
            Operation op = operations.pollFirst();
            int v1 =0, v2=0, result = 0;
            if(numbers.get(op.getIndex()).getType().equals("R")){
                v1 = Conventor.romanToArabic(numbers.get(op.getIndex()).getValue());
                v2 = Conventor.romanToArabic(numbers.get(op.getIndex()+1).getValue());
            }
            else{
                v1 = Integer.parseInt(numbers.get(op.getIndex()).getValue());
                v2 = Integer.parseInt(numbers.get(op.getIndex()+1).getValue());
            }

            switch (op.getType()){
                case '+':{
                    op.updateIndex(operations);
                    result = addition(v1,v2);
                    break;
                }
                case '-':{
                    op.updateIndex(operations);
                    result = substraction(v1,v2);
                    break;
                }
                case '*':{
                    op.updateIndex(operations);
                    result = multiplication(v1,v2);
                    break;
                }
                case '/':{
                    op.updateIndex(operations);
                    if(v2==0)
                        return "Вираз не валідний!!!";
                    result = divide(v1,v2);
                    break;
                }
            }
            numbers.remove(op.getIndex()+1);
            if(numbers.get(op.getIndex()).getType().equals("R")) {
                if(result>1000) {
                    return "Максимальне римське число 1000!!!";
                }
                numbers.get(op.getIndex()).setValue(Conventor.arabicToRoman(result));
            }
            else
                numbers.get(op.getIndex()).setValue(String.valueOf(result));
        }

        if(numbers.isEmpty())
            return "";
        return numbers.get(0).getValue();
    }

    private int addition(int v1, int v2) {
        return v1+v2;
    }

    private int substraction(int v1, int v2) {
        return v1-v2;
    }

    private int multiplication(int v1, int v2) {
       return v1*v2;
    }

    private int divide(int v1, int v2) {
       return (int)v1/v2;
    }
    private  void formOrderOfOperations(String exp){
        int leftIndex = 0,
                rightIndex = -1;

        exp = exp.replaceAll("\\s","");

        for(int i=0;i<exp.length();i++) {
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-'){
                operations.add(new Operation(exp.charAt(i), false));
                leftIndex = rightIndex+1;
                rightIndex = i;
                numbers.add(new Number(exp.substring(leftIndex, rightIndex)));
            }
            else if(exp.charAt(i) == '*' || exp.charAt(i) == '/'){
                operations.add(new Operation(exp.charAt(i), true));
                leftIndex = rightIndex+1;
                rightIndex = i;
                numbers.add(new Number(exp.substring(leftIndex, rightIndex)));
            }else if(i == exp.length()-1){
                leftIndex = rightIndex+1;
                rightIndex = i+1;
                numbers.add(new Number(exp.substring(leftIndex, rightIndex)));
            }

        }

    }
}
