package Hashmap;

import java.util.*;

class PairWithGivenSum {
    static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) return true;
            set.add(num);
        }
        return false;
    }
}

        // Input: [1, 4, 45, 6, 10, 8], target=16
        // Output: [6, 10]