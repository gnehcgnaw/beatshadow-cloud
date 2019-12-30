package com.beatshadow.classloader;

import org.junit.Test;

import java.util.Random;

/**
 * 获取运行时常量的值，会触发类的初始化
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 20:22
 */
public class Test3 {
    @Test
    public void test1(){
        //C Static execution
        //D Static execution
        //d的值
        System.out.println(D.d);
    }


}

class C {
    public final static String C = "c" ;

    static {
        System.out.println("C Static execution");
    }
}

class D extends  C{
    public final static int d = (new Random().nextInt(10));

    static {
        System.out.println("D Static execution");
    }
}
