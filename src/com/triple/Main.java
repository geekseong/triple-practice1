package com.triple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private final static String DELIMITER_COMMA= ",";
    private final static String DELIMITER_SPACE= " ";
    public static void main(String[] args) {

        //test();

        Problem problem = input();
        int answer = problem.solve();
        System.out.println(answer);
    }

    // 사용자 입력 매서드
    private static Problem input(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] split = reader.readLine().split(DELIMITER_SPACE);
            final int N = parseInt(split[0]);
            final int M = parseInt(split[1]);

            List<Place> places = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                split = reader.readLine().split(DELIMITER_COMMA);
                places.add(new Place(split[0], parseInt(split[1]), parseInt(split[2])));
            }

            return new Problem(N, M, places);
        } catch (IOException e) {
            throw new RuntimeException("입력에러");
        }
    }

    // String -> int로 파싱
    private static int parseInt(String num) {
        return Integer.parseInt(num);
    }

    //테스트 수행
    private static void test(){
        List<TestCase> testCases = getTestCaseSet();
        for (TestCase testCase : testCases) {
            testCase.printAnswer();
        }
    }

    
    // 테스트 케이스 정리
    private static List<TestCase> getTestCaseSet(){

        List<TestCase> testSet = new ArrayList<>();

        /** TEST CASE 1 **/
        List<Place> case1Places =  new ArrayList<>(){
            {
                add(new Place("오사카", 2, 5));
                add(new Place("유니버셜스튜디오", 5, 20));
                add(new Place("도톤보리", 1, 10));
                add(new Place("기온", 3, 30));
            }
        };
        testSet.add(new TestCase(new Problem(4, 5, case1Places), 40));


        /** TEST CASE 2 **/
        List<Place> case2Places =  new ArrayList<>(){
            {
                add(new Place("오사카성", 2, 5));
                add(new Place("유니버셜스튜디오", 5, 20));
                add(new Place("도톤보리", 1, 10));
                add(new Place("기온", 3, 30));
            }
        };
        testSet.add(new TestCase(new Problem(4, 3, case1Places), 30));

        return testSet;
    }
}



