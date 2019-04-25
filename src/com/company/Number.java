package com.company;

public class Number {

    private String value;
    private String type;

    public Number(String value) {
        this.value = value;
        setType(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    private void setType(String value) {

        if(value.matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
            type = "R";
        else {
            if(value.matches("\\d+?"))
               type = "A";
            else
                type = "N";
        }
    }
}
