package com.beatshadow.linkedlist;



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
     * 测试在尾部添加
     */
    @Test
    public void testAddAtTheEnd() {
        heroSingleListedList.addAtTheEnd(hero1);
        heroSingleListedList.addAtTheEnd(hero2);
        heroSingleListedList.addAtTheEnd(hero3);
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
}

class SingleListedList<T>{
    private Node<T> head = new Node<>(null,null);

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