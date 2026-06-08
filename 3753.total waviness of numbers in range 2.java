class Solution {

    static class Pair {
        long cnt;
        long sum;

        Pair(long c, long s) {
            cnt = c;
            sum = s;
        }
    }

    private String num;
    private Pair[][][][][] memo;
    private boolean[][][][][] vis;

    private Pair dfs(int pos, int tight, int started, int prev1, int prev2) {
        if (pos == num.length()) {
            return new Pair(1, 0);
        }

        if (vis[pos][tight][started][prev1][prev2]) {
            return memo[pos][tight][started][prev1][prev2];
        }

        vis[pos][tight][started][prev1][prev2] = true;

        long totalCnt = 0;
        long totalSum = 0;

        int limit = (tight == 1) ? num.charAt(pos) - '0' : 9;

        for (int d = 0; d <= limit; d++) {

            int ntight = (tight == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {
                Pair child = dfs(pos + 1, ntight, 0, 10, 10);

                totalCnt += child.cnt;
                totalSum += child.sum;
            } else {

                int nStarted = 1;
                int add = 0;

                if (prev1 != 10 && prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                int nPrev2 = prev1;
                int nPrev1 = d;

                if (prev1 == 10) {
                    nPrev2 = 10;
                    nPrev1 = d;
                }

                Pair child = dfs(pos + 1, ntight, nStarted, nPrev1, nPrev2);

                totalCnt += child.cnt;
                totalSum += child.sum + child.cnt * add;
            }
        }

        return memo[pos][tight][started][prev1][prev2] =
                new Pair(totalCnt, totalSum);
    }

    private long solve(long x) {
        if (x < 0) return 0;

        num = Long.toString(x);

        int n = num.length();

        memo = new Pair[n + 1][2][2][11][11];
        vis = new boolean[n + 1][2][2][11][11];

        return dfs(0, 1, 0, 10, 10).sum;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}