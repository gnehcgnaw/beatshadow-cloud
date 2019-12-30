package com.beatshadow.classloader;

import org.junit.Test;

import java.util.Random;

/**
 * 接口的初始化和普通类加上final的初始化是一样的，因为接口默认的变量都加上了static final
 *      可以分为：编译期常量 和 运行时常量 ，这两种情况和普通类的这两种情况是一样的。
 *
 *      这里我使用了一个技巧，不然就无法知道接口是如何初始化的了。
 *
 *     Thread thread = new Thread(){
 *          {
 *              System.out.println("F init");
 *          }
 *     };
 *
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 21:23
 */
public class Test5 {
    @Test
    public void test1() {
        //G init
        //i的值
        System.out.println(G.i);
    }

    @Test
    public void test2() {
        //G init
        //i的值
        System.out.println(H.i);
    }

    @Test
    public void test3() {
        //hString
        System.out.println(H.hString);
    }

    @Test
    public void test4() {
        //H static execution
        //hInt的值
        System.out.println(H.hInt);
    }
}

interface F {

     Thread thread = new Thread(){
         {
             System.out.println("F init");
         }
    };
}

interface G extends F{

     Thread thread =new Thread(){
        {
            System.out.println("G init ");
        }
    };
    int i = new Random().nextInt(10);
}

class H implements G{
    final static String hString = "hString";
    final static int hInt = new Random().nextInt(10);
    static {
        System.out.println("H static execution");
    }
}