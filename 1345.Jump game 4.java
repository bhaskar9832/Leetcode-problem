import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        // Store all indices for each value
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int index = queue.poll();

                if (index == n - 1) {
                    return steps;
                }

                // Move to index + 1
                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }

                // Move to index - 1
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }

                // Move to all same-value indices
                int value = arr[index];

                if (map.containsKey(value)) {
                    for (int nextIndex : map.get(value)) {
                        if (!visited[nextIndex]) {
                            visited[nextIndex] = true;
                            queue.offer(nextIndex);
                        }
                    }

                    // Important optimization to avoid repeated processing
                    map.remove(value);
                }
            }

            steps++;
        }

        return -1;
    }
}