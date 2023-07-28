package org.example.programmers.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BiggerNumber {

    public static void main(String[] args) {
        int[] numbers = {81, 6, 31, 21, 10};
        String[] arr = new String[numbers.length];

        for( int i = 0; i < arr.length; i++ ){
            arr[i] = String.valueOf(numbers[i]);
        }
//        Arrays.sort(arr, ((o1, o2) -> (o2+o1).compareTo(o1+o2)));
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        System.out.println( Arrays.toString(arr));

        // 0이 포함되는 것을 방지 하기 귀한 로직
//        if(arr[0].equals("0")) return "0";
        System.out.println(String.join("", arr));
    }

}
