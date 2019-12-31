package com.beatshadow.sparsearray;


import java.util.*;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/1 01:31
 */
public class SparseArrayMain {
    public static void main(String[] args) {
        int[][] array = {
                {0,0,0,22,0,0,15},
                {0,11,0,0,0,17,0},
                {0,0,0,-6,0,0,0},
                {0,0,0,0,0,39,0},
                {91,0,0,0,0,0,0},
                {0,0,28,0,0,0,0}
        };
        System.out.println("原始数组");
        printArray(array);
        System.out.println("稀疏数组");
        printArray(toSparseArray(array));
        System.out.println("原始数组");
        printArray(toArray(toSparseArray(array),0));;
    }

    private static void printArray(int[][] array) {
        Arrays.stream(array).forEach((e)->{
            Arrays.stream(e).forEach((f)->{
                System.out.print(f+"\t");
            });
            System.out.print("\n");
        });
    }

    public static int[][] toSparseArray(int[][] array){


        int sum = 0 ;
        for (int i = 0; i < array.length; i++ ) {
            for (int j = 0; j <array[i].length ; j++) {
                if (array[i][j]!=0){
                    sum++;
                }
            }
        }

        int row = sum+1;
        int column = 3;
        int[][] sparseArray = new int[row][column];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        int sparseArrayCount=1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                if (array[i][j]!=0){
                    sparseArray[sparseArrayCount][0] = i;
                    sparseArray[sparseArrayCount][1] = j;
                    sparseArray[sparseArrayCount][2] = array[i][j];
                    sparseArrayCount++ ;
                }
            }
        }

        return sparseArray ;
    }

    public static int[][] toArray(int[][] sparseArray ,int fillerValue){
        int row = sparseArray[0][0] ;
        int column = sparseArray[0][1];
        int count = sparseArray[0][2];
        int [][] array = new int[row][column];

        for (int i = 1; i < sparseArray.length ; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array ;

    }
}
