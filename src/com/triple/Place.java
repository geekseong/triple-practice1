package com.triple;

/**
 * 장소에 대한 Value 클래스
 */
public class Place {
    private final String name;
    private final int spendTime;
    private final int satisfactionScore;

    public Place(String name, int spendTime, int satisfactionScore) {
        this.name = name;
        this.spendTime = spendTime;
        this.satisfactionScore = satisfactionScore;
    }

    public String getName() {
        return name;
    }

    public int getSpendTime() {
        return spendTime;
    }

    public int getSatisfactionScore() {
        return satisfactionScore;
    }
}
