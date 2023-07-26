package org.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockTest {

    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
        MockTest.solution1( answers );

//        MockTest.solution2( answers );
    }

    public static void solution1( int[] answers ){
        int[] ex1 = { 1, 2, 3, 4, 5 };
        int[] ex2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] ex3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int[] cnt = new int[3];

        // answers와 ex들의 답이 맞는지 확인
        for( int i = 0; i < answers.length; i++ ){
            if( answers[i] == ex1[i%ex1.length] ) cnt[0]++;
            if( answers[i] == ex2[i%ex2.length] ) cnt[1]++;
            if( answers[i] == ex3[i%ex3.length] ) cnt[2]++;

        }

        // 제일 많이 맞은사람 확인
        int max = Math.max( cnt[0], Math.max( cnt[1], cnt[2] ) );
        List<Integer> list = new ArrayList<>();

        for( int i = 0; i < cnt.length; i++ ){
            if( max == cnt[i] ){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];
        for( int i = 0; i < list.size(); i++ ){
            answer[i] = list.get(i);
        }

        System.out.println( Arrays.toString(answer) );

    }

    public static void solution2( int[] answers ){
        int[] ex1 = { 1, 2, 3, 4, 5 };
        int[] ex2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] ex3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
    }
}
