package com.hb;

/**
 * @author hubing
 * 测试栈内存不断增加调用方法，每一次调用都是一直引用，方法不会结束
 * 会一直开辟栈帧  当开辟的栈帧达到最大阈值就会栈溢出。StackOverflowError
 */
public class StackOverflowTest {


    static int count = 0;

    static void redo(){
        count++;
        redo();
    }

    public static void main(String[] args) {
        try {
            redo();
        }catch (Throwable t){
            t.printStackTrace();
            System.out.println(count);
        }
    }
}
