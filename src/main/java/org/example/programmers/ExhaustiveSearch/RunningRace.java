package org.example.programmers.ExhaustiveSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RunningRace {

    public static void main(String[] args) {
        // 내가 푼 것
        RunningRace.solution1();
        // 인터넷 검색
        RunningRace.solution2();
    }

    public static void solution1(){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] answer = new String[players.length];
        String[] callings = {"kai", "kai", "mine", "mine"};

        List<String> strList = new ArrayList<>(Arrays.asList(players));
        for (String s : callings ){
            int i = strList.indexOf(s);
            strList.remove(i);
            strList.add(i-1,s);
        }

        System.out.println( Arrays.toString(strList.toArray()));

        System.out.println("==============");

        answer = new String[ strList.size() ];
        for( int i = 0; i < strList.size(); i++ ){
            answer[i] = strList.get(i);
        }

        System.out.println( Arrays.toString(answer) );
    }

    public static void solution2(){
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] answer = new String[players.length];
        String[] callings = {"kai", "kai", "mine", "mine"};

        HashMap<String, Integer> mappedByPlayer = new HashMap<>();
        HashMap<Integer, String> mappedByRank = new HashMap<>();

        // 각각의 맵을 초기화
        for (int i = 0; i < players.length; i++) {
            mappedByPlayer.put(players[i], i);
            mappedByRank.put(i, players[i]);
        }

        for (int i = 0; i < callings.length; i++) {

            // 추월한 유저 순위
            // 추월한 유저 이름
            int currentRank = mappedByPlayer.get(callings[i]);
            String player = mappedByRank.get(currentRank);

            // 바로 앞 플레이어
            String frontPlayer = mappedByRank.get(currentRank - 1);

            // swap
            mappedByPlayer.put(player, currentRank - 1);
            mappedByPlayer.put(frontPlayer, currentRank);

            mappedByRank.put(currentRank - 1, player);
            mappedByRank.put(currentRank, frontPlayer);
        }

        for (int i = 0; i < players.length; i++) {
            answer[i] = mappedByRank.get(i);
        }

        System.out.println( Arrays.toString(answer) );
    }

}
