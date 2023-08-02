package org.example.programmers.stackAndQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PassingTruck {

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = { 7,4,5,6 };

        Queue<Integer> stayQueue = new LinkedList<>();
        Queue<Integer> queuing = new LinkedList<>();
        Queue<Integer> queued = new LinkedList<>();
        for( int num : truck_weights ){
            stayQueue.offer(num);
        }

        int total_bridge = 0;
        int count = 0;
        while (true){
            count++;

            if( !queuing.isEmpty() ){
                for( int num : queuing ){
                    total_bridge += num;
                }
            }

            if( total_bridge < weight && total_bridge + stayQueue.peek() <= weight ){
                queuing.offer(stayQueue.poll());
            }


        }

//        System.out.println("소요시간    ::   " + count);
    }
}
