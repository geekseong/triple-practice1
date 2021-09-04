package com.triple;

import java.util.ArrayList;
import java.util.List;

/**
 * 테스트 케이스 클래스
 * 문제, 문제의 정답을 필드로 저장
 * 알고리즘을 돌린 결과 값과 비교하여 정답, 오답 출력.
 */
public class TestCase {

    private final static String CORRECT_ANSWER_TEMPLATE = "[PASS] expected : %s, answer : %s";
    private final static String INCORRECT_ANSWER_TEMPLATE = "[NOT PASS] expected : %s, answer : %s";

    private Problem problem;
    private int expect;

    public TestCase(Problem problem, int expect) {
        this.problem = problem;
        this.expect = expect;
    }
    public void printAnswer(){
        int answer = this.problem.solve();
        if( answer == expect ){
            System.out.println(String.format(CORRECT_ANSWER_TEMPLATE, expect, answer));
        }
        else {
            System.out.println(String.format(INCORRECT_ANSWER_TEMPLATE, expect, answer));
        }
    }
}
