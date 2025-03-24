package Hashmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int prefixSum = 0;
        boolean found = false;

        // Initialize map with 0 sum at index -1 to capture subarrays starting from index 0
        map.put(0, new LinkedList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefixSum has been seen before, it means a zero-sum subarray exists
            if (map.containsKey(prefixSum)) {
                found = true;
                for (int start : map.get(prefixSum)) {
                    System.out.println("Zero-sum subarray found from index " + (start + 1) + " to " + i);
                }
            }

            // Store the current prefixSum with its index
            map.putIfAbsent(prefixSum, new LinkedList<>());
            map.get(prefixSum).add(i);
        }

        if (!found) {
            System.out.println("No zero-sum subarrays found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findZeroSumSubarrays(arr);
        sc.close();
    }
}
