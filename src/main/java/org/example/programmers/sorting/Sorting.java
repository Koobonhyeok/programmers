package org.example.programmers.sorting;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] array = { 1, 5, 2, 6, 3, 7, 4 };
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3} };

        Sorting.solution1(array,commands);

        Sorting.solution2(array,commands);
    }

    public static void solution1( int[] array, int[][] commands ){
        int[] returnValue = new int[commands.length];
        for( int i = 0; i < commands.length; i++ ){
            int sortCnt= ( commands[i][1] - commands[i][0] ) +1;
            int[] sortArray = new int[ sortCnt ];
            int count = 0;
            for( int j = commands[i][0]; j <= commands[i][1]; j++ ){
                sortArray[count++] = array[j-1];
            }
            count=0;
            Arrays.sort(sortArray);
            returnValue[i] = sortArray[commands[i][2]-1];
//            System.out.println( i +" ::  "+ Arrays.toString(sortArray));
        }

        System.out.println(" 결과 값  ::  " + Arrays.toString(returnValue) );
    }

    public static void solution2( int[] array, int[][] commands ){
        int[] returnValue = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            returnValue[i] = temp[commands[i][2]-1];
        }

        System.out.println(" 결과 값  ::  " + Arrays.toString(returnValue) );
    }


}
