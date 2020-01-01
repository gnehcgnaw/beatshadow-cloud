package com.beatshadow.queue;

import java.util.Arrays;

/**
 * 用数组模拟环形队列
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/1 21:51
 */
public class CircularFifoQueueMain {
    public static void main(String[] args) {
        CircularFifoQueue<String> circularFifoQueue = new CircularFifoQueue<>(3);
        circularFifoQueue.addElement("1");
        circularFifoQueue.addElement("2");
        System.out.println(circularFifoQueue);
        circularFifoQueue.removeElement();
        System.out.println(circularFifoQueue);
        circularFifoQueue.addElement("3");
        System.out.println(circularFifoQueue);
    }
}

class CircularFifoQueue<T> {
    private int front = 0 ;
    private int rear = 0 ;
    private T[] elements ;
    /**
     * 队列的最大有效数据为：（rear+elements.length-front）% element.length
     */
    private int usedSize = 0 ;
    private CircularFifoQueue() {

    }
    public CircularFifoQueue(int maxSize){
        this();
        this.elements = (T[]) new Object[maxSize];
    }

    /**
     * 判断环形队列是否满了
     * @return
     */
    private boolean isFull(){
        if ((rear+1)%elements.length == front){
            return true ;
        }else {
            return false ;
        }
    }

    /**
     * 判断环形队列是否为空
     * @return
     */
    private boolean isEmpty(){
        if (rear == front){
            return true ;
        }else {
            return false ;
        }
    }
    /**
     * 添加元素
     * @param t
     */
    public void addElement(T t){
        if (isFull()) {
            throw new UnsupportedOperationException("环形队列已满，不能添加："+this);
        }else {
            elements[rear] = t ;
            rear =(rear+1)%elements.length ;
            usedSize++;
        }
    }

    /**
     * 移除元素
     * @return
     */
    public T removeElement(){
        if (isEmpty()){
            throw new UnsupportedOperationException("环形队列为空，不能移除元素："+this);
        }else {
            elements[front] = null ;
            front = (front+1)%elements.length ;
            usedSize -- ;

        }
        return null ;
    }
    @Override
    public String toString() {
        return "CircularFifoQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", elements=" + Arrays.toString(elements) +
                ", usedSize=" + usedSize +
                '}';
    }


}

