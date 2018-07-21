package com.gurps.solutions;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary
 * representation of N.
 * <p>
 * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and
 * contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length
 * 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int N); }
 * <p>
 * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
 * <p>
 * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of
 * length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(log(N));
 * expected worst-case space complexity is O(1).
 */
public class BinaryGap {

    public int solution(final int n) {

        if (n < 1 || n > 2147483647) {
            throw new IllegalArgumentException("n must be an integer within the range [1..2,147,483,647].");
        }

        final List<Integer> binaryList = Integer.toBinaryString(n)
                                                .chars()
                                                .mapToObj(Character::getNumericValue)
                                                .collect(toList());

        if (binaryList.size() < 3) {
            return 0; //there is no way it could be a string with 1' on both ends
        }

        final List<Integer> binaryGaps = new ArrayList<>();

        int consecutiveZeroCount = 0;
        for (int i = 0; i < binaryList.size(); i++) {
            if (binaryList.get(i).intValue() == 1) {
                if (i != 0) {
                    binaryGaps.add(consecutiveZeroCount);
                    consecutiveZeroCount = 0; //reset the count
                }
            } else {
                consecutiveZeroCount++;
            }
        }
        return binaryGaps.stream().reduce(0, Integer::max);
    }
}
