package com.triple;

import java.util.Arrays;
import java.util.List;

public class Problem {
    private final static int INF = Integer.MIN_VALUE;
    private final int N, M;
    private final List<Place> places;
    private int[][] scoreTable;

    public Problem(int n, int m, List<Place> places) {
        N = n;
        M = m;
        this.places = places;
        this.scoreTable = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(scoreTable[i], INF);
        }
    }
    public int solve(){
        return search(this.N - 1, this.M);
    }

    // n번째 장소까지 확인했을때, 남은 시간이 leftTime일 경우의 만족도.
    private int search(int n, int leftTime){
        if( n < 0 )
            return 0;

        // 만약 이전에 계산한 값인경우 저장한 값을 재사용.
        if (scoreTable[n][leftTime] != INF) {
            return scoreTable[n][leftTime];
        }

        // n번째 장소를 선택
        final Place nowPlace = places.get(n);

        // n번째 장소를 선택했을떄 주어진 시간을 초과 하는 경우 n번째 선택하지 않고 탐색.
        if (leftTime - nowPlace.getSpendTime() < 0) {
            return scoreTable[n][leftTime] = search(n - 1, leftTime);
        }

        // n번째 장소를 선택했을떄 주어진 시간을 초과 하지 않은 경우 n번째를 선택하고 탐색.
        int choose = search(n - 1, leftTime - nowPlace.getSpendTime()) + nowPlace.getSatisfactionScore();
        int notChoose = search(n-1, leftTime);
        return scoreTable[n][leftTime] = Math.max(choose, notChoose);
    }
}
