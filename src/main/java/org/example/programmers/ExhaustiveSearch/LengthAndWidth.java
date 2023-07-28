package org.example.programmers.ExhaustiveSearch;

public class LengthAndWidth {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = new int[2];

        int sum = brown + yellow;
        for( int i = 3; i < sum; i++ ){
            int j = sum / i;

            if( sum % i == 0 && j >= 3 ){
                int col = Math.max(i, j);
                int row = Math.min(i, j);
                int center = ( col -2 ) * ( row - 2 );

                if( center == yellow ){
                    answer[0] = col;
                    answer[1] = row;
                }
            }

        }
        System.out.println("Width11  ::  " + answer[0] +" Length11  :: " + answer[1]);
    }

    public static void solution(){

    }
}
