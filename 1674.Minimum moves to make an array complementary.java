class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            int min = Math.min(a, b);
            int max = Math.max(a, b);

            int sum = a + b;

            int oneMoveStart = min + 1;
            int oneMoveEnd = max + limit;

            diff[2] += 2;

            diff[oneMoveStart] -= 1;

            diff[sum] -= 1;
            diff[sum + 1] += 1;

            diff[oneMoveEnd + 1] += 1;
        }

        int answer = Integer.MAX_VALUE;
        int moves = 0;

        for (int targetSum = 2; targetSum <= 2 * limit; targetSum++) {
            moves += diff[targetSum];
            answer = Math.min(answer, moves);
        }

        return answer;
    }
}