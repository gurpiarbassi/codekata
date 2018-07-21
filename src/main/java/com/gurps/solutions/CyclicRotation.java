package com.gurps.solutions;

public class CyclicRotation {

    public int[] solution(int[] sourceArray, int amount) {

        if (sourceArray.length == 1) {
            return sourceArray;
        }

        final int[] newArray = new int[sourceArray.length];

        for (int i = 0; i < sourceArray.length; i++) {
            newArray[getNewIndex(i, amount, sourceArray.length)] = sourceArray[i];
        }

        return newArray;
    }

    private int getNewIndex(final int initialIndex, final int shiftAmount, final int arrayLength) {
        int newIndex = (initialIndex + shiftAmount) % arrayLength;
        if (newIndex >= arrayLength) {
            newIndex = newIndex - arrayLength;
        }
        return newIndex;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        final int[] solution = cyclicRotation.solution(new int[]{12}, 3);
        for (int element : solution) {
            System.out.println("element = " + element);
        }
    }
}
