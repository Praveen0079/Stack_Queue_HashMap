package Hashmap;

import java.util.*;

class ZeroSumSubarrays {
    public static List<List<Integer>> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        int prefixSum = 0;

        // Initialize map with 0 sum at index -1 to capture subarrays starting from index 0
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefixSum has been seen before, it means a zero-sum subarray exists
            if (map.containsKey(prefixSum)) {
                for (int start : map.get(prefixSum)) {
                    result.add(Arrays.asList(start + 1, i)); // Store subarray start and end index
                }
            }

            // Store the current prefixSum with its index
            map.putIfAbsent(prefixSum, new ArrayList<>());
            map.get(prefixSum).add(i);
        }

        return result;
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

        List<List<Integer>> subarrays = findZeroSumSubarrays(arr);

        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            System.out.println("Zero-sum subarrays found at indices:");
            for (List<Integer> subarray : subarrays) {
                System.out.println(subarray);
            }
        }

        sc.close();
    }
}
