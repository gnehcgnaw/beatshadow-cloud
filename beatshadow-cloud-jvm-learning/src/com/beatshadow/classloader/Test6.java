package com.beatshadow.classloader;

import org.junit.Test;

/**
 * java8特性之一：default
 *      调用被default修饰的方法的时候，会初始化其父接口
 *
 *
 *
 * 在JAVA8之前java中的接口类型旨在定义类型的接口规约，并不能拥有自己的方法实现，具体实现完全交由实现类自己完成。
 * 以普通人和中上阶层为例，为各自的子女读大学的目标：
 *      普通人大部分甚至可能全部都是告诫子女读书毕业找份好工作；
 *      后者更多要求考TOEFL、GRE、出国留学回来做高管、出资给孩子创业；
 * 接口规约的方法行为是宽泛的，无法具体实现；
 * 而现实中的实现则是符合该规约的实体自己的实现。
 *
 * 但是在JAVA8中可以在接口中定义默认的行为、以及静态方法的实现。
 * 你可以想象，人类文明发展到后面，大家都不需要工作了，完全交由机器人处理。
 * 这时候，人们的行为是一样的： 出生 – 接受各种知识注入脑子里–不工作–等待生命结束(或者永生)。
 * 规约可以有一个稍微具体的实现。大家都可以使用该具体的行为。这就是JAVA8中的default、static方法。
 *
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 21:51
 */
public class
Test6 {
    @Test
    public void test1(){
        // I init
        // J init
        // j
        new K().print();
    }
}

interface I {
    Thread thread = new Thread(){
        {
            System.out.println("I init");
        }
    };

    default void print(){
        System.out.println("i");
    }
}

interface J extends I{
    Thread thread = new Thread(){
        {
            System.out.println("J init");
        }
    };
    @Override
    default void print() {
        System.out.println("j");
    }
}

interface L {
    Thread thread = new Thread(){
        {
            System.out.println("L init");
        }
    };
    default void print(){
        System.out.println("l");
    }
}

class K implements I ,J{

}

/*
class M implements L ,I{

}
一个类实现两个无关联的接口（这里指的是这两个接口没有extends关系），但是这个两个接口中有同一个方法的时候，
类如果不实现方法的重写，则会在编辑期报错。
*/
