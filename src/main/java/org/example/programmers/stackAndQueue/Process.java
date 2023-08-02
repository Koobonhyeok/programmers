package org.example.programmers.stackAndQueue;

import java.util.*;

public class Process {

    public static void main(String[] args) {
        int[] priorities = { 1, 1, 9, 1, 1, 1 };
        int location = 0;

//        Process.solution1(priorities, location);
        Process.solution2(priorities, location);
    }

    public static void solution1( int[] priorities, int location){
        int max = 0;
        for( int priority : priorities ){
            max = Math.max( max, priority );
        }

        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < priorities.length; i++ ){
            if( list.size() != 0 ){
                list.add(i-1);
            }
            if( priorities[i] == max ){
                list.add(i-1);
            }

        }

        int test = priorities.length;
        while(true){
            list.add(0, test-- );

            if( list.size() == priorities.length ){
                break;
            }
        }

        System.out.println(" Result Value  :: "  +  list.get(location));
    }

    public static void solution2( int[] priorities, int location){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (!queue.isEmpty()) {
            int max = 0;

            for (int a : queue) {
                if (a > max) max = a; //현재 queue 중 max값 확인
            }

            if (queue.peek() >= max) { // 첫번째 수가 max value 인 경우
                answer++; //반환된 순서 +1

                if (location == 0) {
                    break;
                } else {
                    queue.poll();
                    location--;
                }
            } else { // max가 아닌 경우
                queue.add(queue.peek()); // 신규 값 insert
                queue.poll(); // 첫번째 값 제거

                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            }
        }
        System.out.println("Result Value  ::  " + answer);
    }
}
