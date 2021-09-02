package com.hb;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @author hubing
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader{
        private String classPath;

    public MyClassLoader(String classPath){
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception{
        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name +".class");
        int len = fis.available();
        byte [] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }
    @Override
    protected Class<?> findClass (String name) throws ClassNotFoundException{
        try{
            byte[] data = loadByte(name);

            return defineClass(name,data,0,data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }


    @Override
    protected  Class<?> loadClass(String name, boolean resolve)throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();

                long t1 = System.nanoTime();
                if(!name.startsWith("com.hb")){
                    c = this.getParent().loadClass(name);
                }else {
                    c = findClass(name);
                }

                sun.misc.PerfCounter.getParentDelegationTime().addTime(t1-t0);
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }



        public static void main(String[] args) throws Exception{

            MyClassLoader classloader = new MyClassLoader("/Users/hubing/Downloads/Projects");

            Class clazz = classloader.loadClass("com.hb.User");

            Object obj = clazz.newInstance();

            Method method = clazz.getDeclaredMethod("sout",null);

            method.invoke(obj,null);

            System.out.println(clazz.getClassLoader().getClass().getName());
        }


    }
}
