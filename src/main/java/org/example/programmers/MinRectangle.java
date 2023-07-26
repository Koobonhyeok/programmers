package org.example.programmers;

import java.util.Arrays;

public class MinRectangle {

    public static void main(String[] args) {
        // DP 방식
//        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        int totalValue = MinRectangle.solution1( sizes );

        System.out.println( "Result Value ::  " + totalValue );

//        MinRectangle.solution2();
    }

    public static int solution1( int[][] sizes ){

        int w_max = 0;
        int h_max = 0;
        int temp = 0;
        for( int i = 0; i < sizes.length; i++ ){
            if( sizes[i][0] < sizes[i][1] ){
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }

            if( w_max < sizes[i][0] ){
                w_max = sizes[i][0];
            }

            if( h_max < sizes[i][1] ){
                h_max = sizes[i][1];
            }
        }

        return w_max * h_max;
    }

    public static void solution2( int[][] sizes ){
        int length = 0;
        int height = 0;
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        int answer = length * height;
    }
}
