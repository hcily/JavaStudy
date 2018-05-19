package com.hc.java.day_12;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class Singleton {
    private Singleton() {
    }

    public static class Holder {
        // 这里的私有没有什么意义
        /* private */ static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        // 外围类能直接访问内部类（不管是否是静态的）的私有变量
        return Holder.instance;
    }
}

class CreateThread extends Thread {
    Object singleton;
    ClassLoader cl;

    public CreateThread(ClassLoader cl) {
        this.cl = cl;
    }

    public void run() {
        Class c;
        try {
            c = cl.loadClass("com.hc.java.day_12.Singleton");
            // 当两个不同命名空间内的类相互不可见时，可采用反射机制来访问对方实例的属性和方法
            Method m = c.getMethod("getInstance", new Class[]{});
            // 调用静态方法时，传递的第一个参数为class对象
            singleton = m.invoke(c, new Object[]{});
            c = null;
            cl = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClassLoaderLK extends ClassLoader {

    private ClassLoader parent = null; // parent classloader
    private String path;

    public ClassLoaderLK(ClassLoader parent, String path) {
        super(parent);
        this.parent = parent; // 这样做其实是无用的
        this.path = path;
    }

    public ClassLoaderLK(String path) {
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        return super.loadClass(name);
        Class<?> cls = findLoadedClass(name);
        if (cls == null) {
//            cls = getSystemClassLoader().loadClass(name); (2)// SystemClassLoader 会从classpath下加载
//            if (cls == null) {(2)
            // 默认情况下， 当前cl的parent是 SystemClassLoader，
            // 而当前cl的parent的parent 才是ExtClassLoader
            ClassLoader parent2 = getParent().getParent();
//                System.out.println("Classloader is : " + parent2);

            try {
                System.out.println("try to use ExtClassLoader to load class : " + name);
                cls = parent2.loadClass(name);
            } catch (ClassNotFoundException e) {
                System.out.println("ExtClassLoader.loadClass :" + name + " Failed");
            }
//            }(2)

            if (cls == null) {
                System.out.println("try to ClassLoaderLK load class : " + name);
                cls = findClass(name);

                if (cls == null) {
                    System.out.println("ClassLoaderLK.loadClass :" + name + " Failed");
                } else {
                    System.out.println("ClassLoaderLK.loadClass :" + name + " Successful");
                }

            } else {
                System.out.println("ExtClassLoader.loadClass :" + name + " Successful");
            }
        }
        return cls;
    }

    @Override
    @SuppressWarnings("rawtypes")
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        return super.findClass(name);
        System.out.println("try findClass " + name);
        InputStream is = null;
        Class class1 = null;
        try {
            String classPath = name.replace(".", "\\") + ".class";
//            String[] fqnArr = name.split("\\."); // split("."); 是不行的， 必须split("\\.")
//            if (fqnArr == null || fqnArr.length == 0) {
//                System.out.println("ClassLoaderLK.findClass()");
//                fqnArr = name.split("\\.");
//            } else {
//                System.out.println( name  +  fqnArr.length);
//            }

            String classFile = path + classPath;
            byte[] data = getClassFileBytes(classFile);

            class1 = defineClass(name, data, 0, data.length);
            if (class1 == null) {
                System.out.println("ClassLoaderLK.findClass() ERR ");
                throw new ClassFormatError();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return class1;
    }

    private byte[] getClassFileBytes(String classFile) throws Exception {
        FileInputStream fis = new FileInputStream(classFile);
        FileChannel fileC = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel outC = Channels.newChannel(baos);
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while (true) {
            int i = fileC.read(buffer);
            if (i == 0 || i == -1) {
                break;
            }
            buffer.flip();
            outC.write(buffer);
            buffer.clear();
        }
        fis.close();
        return baos.toByteArray();
    }

}

class SingleTest {
    public static void main(String[] args) throws Exception {

        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("sun.boot.class.path"));

//        while (true) {
            ClassLoader parentClassLoader = ClassLoaderLK.class.getClassLoader();
            System.out.println("parentClassLoader is " + parentClassLoader);
            System.out.println("ClassLoader is " + parentClassLoader.getParent());
            System.out.println("ClassLoader is " + parentClassLoader.getParent().getParent());

            // 不能让系统加载器直接或间接的成为父加载器
            ClassLoaderLK loader1 = new ClassLoaderLK("D:\\eclipse-workspace\\JavaStudy\\out\\production\\JavaStudy\\");
            ClassLoaderLK loader2 = new ClassLoaderLK("D:\\eclipse-workspace\\JavaStudy\\out\\production\\JavaStudy\\");
            CreateThread ct1 = new CreateThread(loader1);
            CreateThread ct2 = new CreateThread(loader2);
            ct1.start();
            ct2.start();
            ct1.join();
            ct2.join();
            if (ct1.singleton != ct2.singleton) {
                System.out.println(ct1.singleton + " " + ct2.singleton);
            }
            System.out.println(ct1.singleton + " " + ct2.singleton);
            ct1.singleton = null;
            ct2.singleton = null;
            Thread.yield();
//        }
    }
}