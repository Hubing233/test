package com.hb;

/**
 * @author hubing
 */
public class Math {


    public static final int initData = 6666;

    public static User user = new User();

    public int compute(){
        int a = 1;
        int b = 3;
        int c = (a + b) * 10;

        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        while (true){
            math.compute();
        }

    }
}
