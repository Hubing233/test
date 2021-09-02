package com.hb;

/**
 * @author hubing
 *
 */
public class AllotOnStack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0 ;i < 100000000;i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    private static void alloc(){
        User user = new User();
        user.setId(1);
        user.setName("hb");
    }
}
