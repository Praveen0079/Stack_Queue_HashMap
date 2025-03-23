package Hashmap;

import java.util.*;

class LongestConsecutiveSequence {
    static int longestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);
        int maxLength = 0;
        
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentNum = num, count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}

// Input: [100, 4, 200, 1, 3, 2]
// Output: 4