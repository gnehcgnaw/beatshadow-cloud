package com.beatshadow.linkedlist;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/5 18:09
 */
public class SingleListMainTest {
    public static Hero hero1 ;
    public static Hero hero2 ;
    public static Hero hero3 ;
    public SingleListedList<Hero> heroSingleListedList ;
    @Before
    public  void setup(){
        hero1 = new Hero(1,"林冲","及时雨");
        hero2 = new Hero(2,"卢俊义","玉麒麟");
        hero3 = new Hero(3,"吴用","智多星");
        heroSingleListedList = new SingleListedList<>() ;
    }

    /**
     * 初始化单链表
     */
    private void init() {
        heroSingleListedList.addAtTheEnd(hero1);
        heroSingleListedList.addAtTheEnd(hero2);
        heroSingleListedList.addAtTheEnd(hero3);
    }

    /**
     * 测试在尾部添加
     */
    @Test
    public void testAddAtTheEnd() {
        init();
        System.out.println(heroSingleListedList.toString());
    }

    /**
     * 在指定位置添加元素
     */
    @Test
    public void testAddAtTheSpecifiedPosition(){
        heroSingleListedList.addAtTheSpecifiedPosition(hero3);
        heroSingleListedList.addAtTheSpecifiedPosition(hero2);
        heroSingleListedList.addAtTheSpecifiedPosition(hero1);
        System.out.println(heroSingleListedList.toString());
    }

    //单链表面试题
    //1. 获取单链表中节点的个数
    //2. 查找单链表中的倒数第K个节点『新浪面试题』
    //3. 单链表的反转『腾讯面试题』
    //4. 从头到尾打印单链表『百度：要求方式1：反向遍历。方式二：Stack栈』
    //5. 合并两个有序的单链表，合并之后的链表依然有序

    /**
     * 1. 获取单链表中节点的个数
     */
    @Test
    public void testSize() {
        init();
        System.out.println(heroSingleListedList.size());
    }

    /**
     * 2. 查找单链表中的倒数第K个节点『新浪面试题』
     */
    @Test
    public void testLastIndexOf() {
        init();
        Assert.assertEquals(1,heroSingleListedList.lastIndexOf(3).getData().getId());
    }
    /**
     * 3. 单链表的反转『腾讯面试题』
     */
    @Test
    public void testTranspose() {


    }
    /**
     * 4. 从头到尾打印单链表『百度：要求方式1：反向遍历。方式二：Stack栈』
     */

    /**
     * 5. 合并两个有序的单链表，合并之后的链表依然有序
     */
}

class SingleListedList<T>{
    private Node<T> head = new Node<>(null,null);

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * 在尾部添加
     * @param t
     * @return
     */
    public boolean addAtTheEnd(T t){
        Node<T> node = new Node<>(t);
        try {
            Node<T> temp = head ;
            while (true){
                if (temp.getNextNode()==null){
                    break;
                }else {
                    temp = temp.getNextNode();
                }
            }
            temp.setNextNode(node);
            return true ;
        }catch (Exception ex){
            return false ;
        }
    }

    /**
     * 下面这段代码是入侵时代码，在观察源码之后，会对齐做出调整
     * 在指定位置添加
     * @param t
     * @return
     */
    public boolean addAtTheSpecifiedPosition(T t){
        try{
            Node<T> tNode = new Node<>(t);
            Node<T> temp = head ;
            boolean flag = false ;
            while (true){
                if (temp.getNextNode()==null){
                    break;
                }
                Hero hero = (Hero)temp.getNextNode().getData();
                int tempId = hero.getId();
                int currentId = ((Hero) t).getId();
                if (tempId>currentId){
                    break;
                }else if (tempId == currentId){
                    flag = true ;
                    break;
                }else {
                    temp = temp.getNextNode();
                }
            }
            if (flag){
                System.out.println("不能添加，节点已存在"+((Hero) temp.getData()).id);
            }else {
                tNode.setNextNode(temp.getNextNode());
                temp.setNextNode(tNode);
            }
            return true ;
        } catch (Exception ex){
            return  false ;
        }

    }



    /**
     * index指的是下标
     * 更新节点数据
     * @return
     */


    /**
     * 删除节点
     * @param index
     * @return
     */
    public Node<T> remove(int index){
        if (index<1||index>size()||this.size()==0){
            throw  new UnsupportedOperationException("非法错误");
        }else{
            Node<T> head = this.getHead();
            Node<T> temp = head ;
            for (int i = 0; i < this.size() - 1 ; i++) {
                if (i == index -1){
                    break;
                }else {
                    temp = temp.getNextNode();
                }
            }
        return temp ;
        }

    }

    //面试题
    /**
     *  1. 获取单链表中节点的个数
     * @return
     */
    public int size(){
        Node<T> head = this.getHead();
        int size = 0 ;
        Node<T> temp = head;
        while (true){
            if (temp.getNextNode() != null) {
                size++;
                temp = temp.getNextNode();
            }else{
                break;
            }
        }
        return size ;
    }

    /**
     * 2. 查找单链表中的倒数第K个节点『新浪面试题』
     * @param index
     * @return
     */
    public Node<T> lastIndexOf(int index){
        int size = this.size();
        if (index==0||size-index<0||size-index>size){
            throw new UnsupportedOperationException("此index是不合法操作");
        }else{
            Node<T> temp = this.getHead().getNextNode();
            for (int i = 0; i <size-index; i++) {
                temp = temp.getNextNode();
            }
            return temp ;
        }
    }
    /**
     * 3. 单链表的反转『腾讯面试题』
     */
    public SingleListedList<T> transpose(){
        //最终要返回的单链表
        SingleListedList<T> targetSingleListedList = new SingleListedList<>();
        //原链表的头节点
        Node<T> sourceHead = this.getHead();
        while (true){
            Node<T> nextNode = sourceHead.getNextNode();
            if (nextNode!=null){
                Node<T> nextNode1 = sourceHead.getNextNode().getNextNode();
                if (nextNode1!=null){

                }

            }


        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",");
        Node<T> temp = head ;
        while (true){
            if (temp.getNextNode()==null){
                break;
            }else {
                temp = temp.getNextNode();
                stringJoiner.add(temp.getData().toString());
            }
        }
        return stringJoiner.toString();
    }
}

class Node<T> {
    private T data ;
    private Node<T> nextNode;

    public Node() {
    }

    public Node(T data, Node<T> nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }
}

class Hero{
    public Hero() {
    }

    public Hero(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    int id ;
    String name ;
    String nickName ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}