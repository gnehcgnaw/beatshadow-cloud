package com.beashadow.classloader;

/**
 *
 * -XX:+TraceClassLoading 用于追踪类的加载信息，并打印出来
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/28 09:43
 */
public class Example1 {
    public static void main(String[] args) {
        String parent = Parent.parent;
        System.out.println(parent);
    }
}

class Parent {
    /**
     *   final 和 !final
     */
    public final  static String parent = "parent" ;

    static {
        System.out.println("Parent Static");
    }
}

class Son extends Parent{
    public static String son = "son" ;

    static {
        System.out.println("Son Static");
    }

}
