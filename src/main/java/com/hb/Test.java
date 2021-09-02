package com.hb;

/**
 * @author hubing
 */
public class Test {
    public Test(){

    }
    public int compute(){
        int i = 1;
        i = i++;

        System.out.println(i);

        return i;


    }


    public static void main(String[] args) {
       Test test = new Test();
       test.compute();
    }

}
