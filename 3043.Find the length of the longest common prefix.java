import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();

        // Store all prefixes of every number in arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        int maxLen = 0;

        // Check prefixes of every number in arr2
        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    maxLen = Math.max(maxLen, digitCount(num));
                    break; 
                }
                num /= 10;
            }
        }

        return maxLen;
    }

    private int digitCount(int num) {
        int count = 0;

        while (num > 0) {
            count++;
            num /= 10;
        }

        return count;
    }
}