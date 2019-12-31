package com.beatshadow.classloader;

import org.junit.Test;

/**
 * 理解类的加载、初始化过程
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 22:54
 */
public class Test8 {
    @Test
    public void test1(){
        /*
         * current i is : 1
         * current j is : 1
         * result i is : 1
         * result j is : 1
         */
        Singleton1 singleton1 = Singleton1.newInstance();
        System.out.println("result i is : "+Singleton1.i);
        System.out.println("result j is : "+Singleton1.j);

    }

    @Test
    public void test2(){
        /*
         *  current i is : 1
         *  current j is : 1
         *  result i is : 1
         *  result j is : 0
         */
        Singleton2 singleton2 = Singleton2.newInstance();
        System.out.println("result i is : "+Singleton2.i);
        System.out.println("result j is : "+Singleton2.j);
    }


    @Test
    public void test3(){
        /*
         *  current i is : 2
         *   current j is : 1
         *   result i is : 2
         *  result j is : 0
         */
        Singleton3 singleton3 = Singleton3.newInstance();
        System.out.println("result i is : "+Singleton3.i);
        System.out.println("result j is : "+Singleton3.j);
    }



    @Test
    public void test4(){
        /*
         *  current i is : 1
        *   current j is : 1
        *   result i is : 1
        *   result j is : 0
         */
        Singleton4 singleton4 = Singleton4.newInstance();
        System.out.println("result i is : "+Singleton4.i);
        System.out.println("result j is : "+Singleton4.j);
    }

}

class Singleton1{

    public  static int i ;
    public  static int j = 0;

    private static Singleton1 singleton1 = new Singleton1();

    private Singleton1() {
        i++;
        j++;
        System.out.println("current i is : "+i);
        System.out.println("current j is : "+j);
    }

    public static Singleton1 newInstance(){
        return singleton1;
    }

}

class Singleton2{

    public  static int i ;
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
        i++;
        j++;
        System.out.println("current i is : "+i);
        System.out.println("current j is : "+j);
    }
    public  static int j = 0;
    public static Singleton2 newInstance(){
        return singleton2;
    }

}


class Singleton3{

    public  static int i = 1;

    private static Singleton3 singleton3 = new Singleton3();
    private Singleton3() {
        i++;
        j++;
        System.out.println("current i is : "+i);
        System.out.println("current j is : "+j);
    }
    public  static int j = 0;
    public static Singleton3 newInstance(){
        return singleton3;
    }

}

class Singleton4{


    private static Singleton4 singleton4 = new Singleton4();
    public  static int i = 1;
    private Singleton4() {
        i++;
        j++;
        System.out.println("current i is : "+i);
        System.out.println("current j is : "+j);
    }
    public  static int j = 0;
    public static Singleton4 newInstance(){
        return singleton4;
    }

}

