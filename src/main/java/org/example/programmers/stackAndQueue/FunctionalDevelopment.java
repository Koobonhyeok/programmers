package org.example.programmers.stackAndQueue;

import java.util.*;

public class FunctionalDevelopment {

    public static void main(String[] args) {
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

//        FunctionalDevelopment.solution1(progresses, speeds);
        FunctionalDevelopment.solution2(progresses, speeds);
    }

    public static void solution1( int[] progresses, int[] speeds ){
        List<Integer> list = new ArrayList<>();
        // 각자 progresses가 반영이 가능한 날짜 구하기
        for( int i = 0; i <progresses.length; i++ ){
            int day = 0;
            int progress = progresses[i];

            while ( true ){
                if( progress >= 100 ){
                    list.add(day);
                    break;
                }
                day++;
                progress += speeds[i];
            }
        }

        int preNum = 0;
        int check = 1000;
        List<Integer> checkList = new ArrayList<>();
        // 실제 반응 가능한 날짜 구하기
        for( int num = 0; num < list.size(); num++ ){
            if( preNum >= list.get(num) ){
                if( check == 1000 )
                    preNum = list.get(num);

                check++;
            }else {
                if( check != 1000)
                    checkList.add(check);

                preNum = list.get(num);
                check = 1;

            }
            if( num == list.size() -1 ){
                checkList.add(check);
            }
        }

        int[] answer = new int[checkList.size()];
        for(int i = 0; i < checkList.size(); i++){
            answer[i] = checkList.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    public static void solution2( int[] progresses, int[] speeds ){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

}
