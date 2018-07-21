package com.gurps.solutions;

public class OddOccurrencesInArray {

    public int solution(int[] sourceArray) {

        int result = 0;
        for (int i = 0; i < sourceArray.length; i++) {
            result = result ^ sourceArray[i];
        }

        return result;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray program = new OddOccurrencesInArray();
        final int solution = program.solution(new int[]{22});
        System.out.println("solution = " + solution);
    }
}
