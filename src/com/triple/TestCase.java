package com.triple;

import java.util.ArrayList;
import java.util.List;

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
