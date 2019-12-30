package com.beatshadow.classloader;

import org.junit.Test;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2019/12/30 19:48
 */
public class Test1 {
    @Test
    public void test1(){
        //Parent Static execution
        //parent
        System.out.println(Parent.parent);
    }

    @Test
    public void test2(){
        //Parent Static execution
        //Son Static execution
        //son
        System.out.println(Son.son);
    }

    /**
     * 被动引用1
     */
    @Test
    public void test3(){
        //Parent Static execution
        //parent
        System.out.println(Son.parent);
    }

    @Test
    public void test4(){
        //Parent Static execution
        //parent
        //parent
        System.out.println(Parent.parent);
        System.out.println(Son.parent);
    }

    @Test
    public void test5(){
        //Parent Static execution
        //parent
        //parent
        System.out.println(Son.parent);
        System.out.println(Parent.parent);
    }

    @Test
    public void test6(){
        //Parent Static execution
        //Son Static execution
        //son
        //parent
        System.out.println(Son.son);
        System.out.println(Parent.parent);
    }

    @Test
    public void test7(){
        //Parent Static execution
        //parent
        //Son Static execution
        //son
        System.out.println(Parent.parent);
        System.out.println(Son.son);
    }

    @Test
    public void test8(){
        //Parent Static execution
        //Son Static execution
        Son son = new Son();
    }

    @Test
    public void test9(){
        //Parent Static execution
       Parent parent = new Parent() ;
    }

    /**
     * 调用类的static方法的时候，会初始化自己，但是如果发现其父类没有被初始化，则会先初始化父类（这里不包括实现接口）,
     *
     * 调用类的static方法的时候，即便是上面有接口，接口也不会被初始化，参见{@link Test7#test3()}
     */
    @Test
    public void test10(){
        //Parent Static execution
        //Son Static execution
        //Son static method execution
        Son.print();
    }


}

class Parent{
   public static String parent = "parent" ;

   static {
       System.out.println("Parent Static execution");
   }
}

class Son extends  Parent{
    public static String son = "son" ;

    static {
        System.out.println("Son Static execution");
    }

    static void print(){
        System.out.println("Son static method execution");
    }
}