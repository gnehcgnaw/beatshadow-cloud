package com.beatshadow.classloader;

import org.junit.Test;

/**
 * 被动引用2：
 *      获取编译器常量的值，不会触发类的初始化，因为在编译时数值就被放在静态常量池中了。
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 20:14
 */
public class Test2 {

    @Test
    public void test1(){
        //a
        System.out.println(A.a);
    }

    @Test
    public void test2(){
        //a
        System.out.println(B.a);
    }

    @Test
    public void test3(){
        //b
        System.out.println(B.b);
    }

}


class A{
    public final static String a = "a" ;

    static {
        System.out.println("A Static execution");
    }
}

class B extends  A{
    public final static String b = "b" ;

    static {
        System.out.println("B Static execution");
    }
}