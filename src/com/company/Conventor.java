package com.company;

public class Conventor {
    public static int romanToArabic(String v1){
        int v1ToInt =0;
        for(int i=0;i<v1.length();i++){
            if(i!=0) {
                String temp = String.valueOf(v1.charAt(i));
                String temp1 = String.valueOf(v1.charAt(i - 1));
                if (Roman.valueOf(temp1).toInt() < Roman.valueOf(temp).toInt())
                    v1ToInt = v1ToInt - 2*Roman.valueOf(temp1).toInt() + Roman.valueOf(temp).toInt();
                else
                    v1ToInt += Roman.valueOf(temp).toInt();
            }
            else {
                String temp = String.valueOf(v1.charAt(i));
                v1ToInt += Roman.valueOf(temp).toInt();
            }
        }
        return v1ToInt;
    }
    public static String arabicToRoman(int number) {

        String romanValue = "";

        int N = number;
        Roman r1 = null;
        Roman r3 = null;
        while ( N > 0 )
        {
            boolean flag = true;
            boolean flag1 = true;
            for(Roman r : Roman.values()){


                if(flag){
                    r1 = r;
                    flag = false;
                    r3 = r;
                }
                else {
                    if(N >= r.toInt()-r3.toInt() && N < r.toInt()){
                        N -= r.toInt()-r3.toInt();
                        romanValue += r3.name() + r.name();
                        break;
                    }else{
                        if (N < r.toInt()) {
                            N -= r1.toInt();
                            romanValue += r1.name();
                            break;
                        }
                    }
                    flag1 = !flag1;
                    if(flag1){
                        r3 = r;
                    }
                }
                r1 = r;
            }
        }
        return romanValue;
    }
}
