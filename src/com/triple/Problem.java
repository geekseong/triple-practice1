package com.triple;

import java.util.Arrays;
import java.util.List;

/**
 * 문제의 입력과 알고리즘을 포함한 클래스
 */
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
//        return solution1(this.N - 1, this.M);
        return solution2(this.N - 1, this.M);
    }

    // 제귀함수 방식으로 구현
    // n번째 장소까지 확인했을때, 남은 시간이 leftTime일 경우의 만족도.
    private int solution1(final int n, final int leftTime){
        if( n < 0 )
            return 0;

        // 만약 이전에 계산한 값인경우 저장한 값을 재사용.
        if (this.scoreTable[n][leftTime] != INF) {
            return this.scoreTable[n][leftTime];
        }

        // n번째 장소를 선택
        final Place nowPlace = this.places.get(n);

        // n번째 장소를 선택했을떄 주어진 시간을 초과 하는 경우 n번째 선택하지 않고 탐색.
        if (leftTime - nowPlace.getSpendTime() < 0) {
            return this.scoreTable[n][leftTime] = solution1(n - 1, leftTime);
        }

        // n번째 장소를 선택했을떄 주어진 시간을 초과 하지 않은 경우 n번째를 선택하고 탐색.
        int choose = solution1(n - 1, leftTime - nowPlace.getSpendTime()) + nowPlace.getSatisfactionScore();
        int notChoose = solution1(n-1, leftTime);
        return this.scoreTable[n][leftTime] = Math.max(choose, notChoose);
    }

    // 테이블을 순회하는 방식으로 구현
    // n번째 장소까지 확인했을때, 남은 시간이 leftTime일 경우의 만족도.
    private int solution2(final int n, final int leftTime) {

        for (int i = 0; i <= n; i++) {

            // n번째 장소를 선택
            final Place nowPlace = this.places.get(i);

            for (int j = 0; j <= leftTime; j++) {

                // n번째 장소를 선택했을떄 주어진 시간을 초과 하는 경우 n번째 선택하지 않고 탐색.
                if (j - nowPlace.getSpendTime() < 0) {
                    this.scoreTable[i][j] = i - 1 < 0 ? 0 : this.scoreTable[i - 1][j];
                }

                // n번째 장소를 선택했을떄 주어진 시간을 초과 하지 않은 경우 n번째를 선택하고 탐색.
                else {
                    int nowScore = nowPlace.getSatisfactionScore();
                    int choose = i - 1 < 0 ? nowScore : this.scoreTable[i - 1][j - nowPlace.getSpendTime()] + nowScore;
                    int notChoose = i - 1 < 0 ? 0 : this.scoreTable[i - 1][j];
                    this.scoreTable[i][j] = Math.max(choose, notChoose);
                }
            }
        }

        return this.scoreTable[n][leftTime];
    }
}
