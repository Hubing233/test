package com.hb;

import java.util.ArrayList;

/**
 * @author hubing
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true){
                list.add(new OOMObject());
        }
    }
}

