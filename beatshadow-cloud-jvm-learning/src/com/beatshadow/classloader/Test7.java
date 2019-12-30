package com.beatshadow.classloader;

import org.junit.Test;

/**
 * java8 特性： 接口中定义static方法
 * 调用类的static 虽然会触发其本类初始化，以及父类的初始化，但是不会触发其接口的初始化
 *      这里就区分出来：父类 和 接口的区别。
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 22:11
 */
public class Test7 {
    @Test
    public void test1(){
        //M init
        //N init
        M.print();
    }

    @Test
    public void test2(){
        //N init
        //N.print
        N.print();
    }

    @Test
    public void test3(){
        //O init
        //O.print
        O.print();
    }
}

interface M {
    Thread thread = new Thread(){
        {
            System.out.println("M init");
        }
    };
    static void print(){
        System.out.println("M.print");
    }
}
interface N extends M {
    Thread thread = new Thread(){
        {
            System.out.println("N init");
        }
    };

    static void print(){
        System.out.println("N.print");
    }
}

class O implements N{
    static {
        System.out.println("O init");
    }
    static void print(){
        System.out.println("O.print");
    }
}