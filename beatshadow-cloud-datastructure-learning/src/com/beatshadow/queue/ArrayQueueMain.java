package com.beatshadow.queue;

import java.util.Arrays;

/**
 * 这种队列不能复用，需要改进
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/1 13:29
 */
public class ArrayQueueMain {
    public static void main(String[] args) throws Exception {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(4);
        arrayQueue.addData("1");
        arrayQueue.addData("2");
        arrayQueue.addData("3");
        arrayQueue.addData("4");
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue.remove());
        System.out.println(arrayQueue);
        arrayQueue.addData("3");
        System.out.println(arrayQueue);
    }
}


class ArrayQueue<T> {
    /**
     *  头部
     */
    private int front = -1 ;
    /**
     *  尾部
     */
    private int rear = -1 ;
    /**
     * 容量
     */
    private int maxSize ;

    private  T[] container ;

    private ArrayQueue() {

    }

    /**
     * 根据容量大小初始化一个队列
     * @param maxSize
     */
    public ArrayQueue(int maxSize) throws Exception {
        this();
        this.maxSize = maxSize;
        this.container =  (T[]) new Object[maxSize];
    }
    /**
     *
     * @param t 要加入队列的数据
     * @throws Exception
     */
    public void addData(T t) throws Exception {
        if (rear<maxSize-1){
            //判断存入的数据是否达到最大容量
            rear++ ;
            container[rear]=t ;
        }else {
            throw new Exception("队列已达到最大容量："+this);
        }
    }

    public T remove() throws Exception {
        T t = null;
        //判断是否还有元素
        if (rear-front==0||(rear==-1&&front==-1)){
            throw  new Exception("队列中已没有元素："+this);
        }else{
            T [] tempContainer = (T[]) new Object[maxSize];
            for (int i = 0; i < tempContainer.length; i++) {
                if (i+1<container.length){
                    tempContainer[i] = container[i+1];
                }
                t = container[0];
            }
            front ++ ;
            container = tempContainer ;
        }
        return t ;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "front=" + front +
                ", rear=" + rear +
                ", maxSize=" + maxSize +
                ", container=" + Arrays.toString(container) +
                '}';
    }
}