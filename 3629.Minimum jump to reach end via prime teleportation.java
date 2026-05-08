import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int maxVal = 0;

        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        // Sieve for prime checking
        boolean[] isPrime = sieve(maxVal);

        // value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        // To avoid processing same prime again
        boolean[] usedPrime = new boolean[maxVal + 1];

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                // Reached destination
                if (idx == n - 1) {
                    return steps;
                }

                // Move left
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Move right
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                // Prime teleportation
                if (isPrime[val] && !usedPrime[val]) {

                    usedPrime[val] = true;

                    // Visit all multiples of val
                    for (int multiple = val; multiple <= maxVal; multiple += val) {

                        List<Integer> list = map.get(multiple);

                        if (list == null) {
                            continue;
                        }

                        for (int nextIdx : list) {

                            if (!visited[nextIdx]) {
                                visited[nextIdx] = true;
                                q.offer(nextIdx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private boolean[] sieve(int n) {

        boolean[] prime = new boolean[n + 1];

        Arrays.fill(prime, true);

        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;

        for (int i = 2; i * i <= n; i++) {

            if (prime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }
}