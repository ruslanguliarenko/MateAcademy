package com.company;

import java.util.TreeSet;

public class Operation implements Comparable<Operation>{

    private char type;
    private boolean isFirstPriority;
    private int index = 0;
    private static int i = 0;

    public Operation(char type, boolean isFirstPriority) {
        this.type = type;
        this.isFirstPriority = isFirstPriority;
        index = i;
        i++;
    }



    @Override
    public String toString(){
        final String s = type + " " + isFirstPriority +" "+ index;
        return s;
    }

    @Override
    public int compareTo(Operation o) {
        if(this.isFirstPriority == o.isFirstPriority) {
            if(this.index > o.index)
                return 1;
            else
                return -1;
        }
        else {
            if(this.isFirstPriority)
                return -1;
            else
                return 1;
        }

    }

    public void updateIndex(TreeSet<Operation> operations){
        for(Operation o : operations){
            if(this.getIndex()< o.getIndex())
                o.setIndex(o.getIndex()-1);
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public char getType() {
        return type;
    }
}

