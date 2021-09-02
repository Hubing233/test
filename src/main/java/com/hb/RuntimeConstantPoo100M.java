package com.hb;

import java.util.ArrayList;

/**
 * @author hubing
 * 证明字符串常量池是放在堆里面的。
 */
public class RuntimeConstantPoo100M {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 1000000; j++) {
                list.add(String.valueOf(i + j / 1000000).intern());
            }
        }
    }
}
