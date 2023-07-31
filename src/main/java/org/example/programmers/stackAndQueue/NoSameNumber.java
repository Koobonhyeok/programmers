package org.example.programmers.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoSameNumber {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        List<Integer> list = new ArrayList<>();

        boolean ch = true;
        int count = 0;
        for( int num : arr ){
            if( ch ){
                list.add(num);
                ch = false;
                count++;
            } else if( list.get(count -1) != num ){
                list.add(num);
                count++;
            }

        }

        int[] answer = new int[list.size()];
        for( int i = 0; i < list.size(); i++ ){
            answer[i] = list.get(i);
        }

        System.out.println( Arrays.toString( answer ) );
    }

    public static void solution1(){

    }
}
