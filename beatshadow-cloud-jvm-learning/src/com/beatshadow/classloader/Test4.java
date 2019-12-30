package com.beatshadow.classloader;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 被动引用3：数组
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 20:36
 */
public class Test4 {
    @Test
    public void test1(){
        E[] es = new E[10];
        //class [Lcom.beatshadow.classloader.E;
        System.out.println(es.getClass());
        //class java.lang.Object
        System.out.println(es.getClass().getSuperclass());
        List<E> list = new ArrayList<>();
        //[]
        System.out.println(list);
        //class java.util.AbstractList
        System.out.println(list.getClass().getSuperclass());

    }
}

class E {
    static {
        System.out.println("E static execution");
    }
}