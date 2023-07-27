package org.example.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class PrimeNumbers {
    static HashSet<Integer> numbersSet = new HashSet<>();

    public static void main(String[] args) {
        String number = "17";
        int answer = 0;

        answer = PrimeNumbers.solution1( number );

        System.out.println( "result value  :: " + answer );
    }

    public static int solution1( String number ){
        PrimeNumbers.recursive("", number);

        int count = 0;
        Iterator<Integer> iter = numbersSet.iterator();
        while( iter.hasNext() ){
            int number1 = iter.next();
            if( PrimeNumbers.isPrime(number1) ){
                count++;
            }
        }

//        Iterator iter = numbersSet.iterator();
//        while ( iter.hasNext() ){
//            int num = Integer.valueOf( iter.next().toString() );
//            boolean check = true;
//            for( int i = 2; i < Math.sqrt(num); i++ ){
//                if( num % i == 0 ){
//                    check = false;
//                    break;
//                }
//            }
//
//            if( check ){
//                primeNum.add(num);
//            }
//        }
        return count;
    }

    public static void recursive( String comb, String number ){
        if(!comb.equals("")) {
            numbersSet.add( Integer.parseInt(comb) );
        }

        for( int i = 0; i < number.length(); i++ ){
            if( !comb.equals("") ){
                numbersSet.add( Integer.valueOf(comb) );
            }
            recursive(comb + number.charAt(i)  , number.substring(0, i) + number.substring(i+1) );
        }
    }

//    public static void recursive( String comb, String others){
//        if (!comb.equals(""))
//            numbersSet.add(Integer.valueOf(comb));
//
//        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
//        for (int i = 0; i < others.length(); i++)
//            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
//    }

    public static boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}
