package com.hb;

import java.util.ArrayList;

/**
 * @author hubing
 * Eden一直放，放满做一次GC，放到S0，继续放，GC，放到S0，S1进入到OLD，一直循环。
 *
 */
public class HeapTest {

    byte[] a = new byte[1024 * 100];

    public static void main(String[] args) throws InterruptedException{
        ArrayList<HeapTest> heapTests = new ArrayList<>();
        while (true){
            heapTests.add(new HeapTest());
            Thread.sleep(10);
        }
    }
}
