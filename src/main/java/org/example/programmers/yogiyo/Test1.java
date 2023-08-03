package org.example.programmers.yogiyo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        int N = 8;
        int K = 3;
        String res = Test1.tst(N, K);

        System.out.println(res);
    }
//    pfkfpffk
//    p f k
    public static String tst( int N, int K ){
        Set<String> set = new HashSet<>();
        while( true ){
            if( set.size() == K ){
                break;
            }

            set.add( String.valueOf((char)((int)(Math.random()*26)+97)) );
        }

        StringBuffer resultValue = new StringBuffer();
        Iterator<String> iterSet = set.iterator();
        while(iterSet.hasNext()){
            resultValue.append(iterSet.next());
        }
        StringBuffer test = new StringBuffer(resultValue);
        System.out.println(test.reverse() );

        Random random = new Random();
        for(int i = K; i < N-K; i++){
            resultValue.append( resultValue.charAt(random.nextInt(K)) );
        }

        resultValue.append(test);

        return  resultValue.toString();
    }
}
