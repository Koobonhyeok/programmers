package org.example.programmers.ExhaustiveSearch;

public class Fatigue {
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = { { 80,20 }, { 50, 40 }, { 30, 10 } };

        visited = new boolean[dungeons.length];

        Fatigue.dfs(0 , k , dungeons);

        System.out.println("  Count    ::::     " + count);
    }

    public static void solution1(){

    }

    private static void dfs( int depth, int fatigue, int[][] dungeons){
        for (int i = 0; i < dungeons.length; i++){
            if (visited[i] || dungeons[i][0] > fatigue) {
//                System.out.println( i+ "Visited status :: "+ visited[i] +"// dungeons Min F :: "+ dungeons[i][0] +"// Fatigue  :: " + fatigue  );
                continue;
            }
            System.out.println("dd :: "+depth+ " :"+i+ "Visited status :: "+ visited[i] +"// dungeons Min F :: "+ dungeons[i][0] +"// Fatigue  :: " + fatigue +"  " + (dungeons[i][0] > fatigue)  );

            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }

//        System.out.println( "    depth     ::   "+depth  );
        count = Math.max(count, depth);
    }
}
