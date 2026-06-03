import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );

        return (int) ans;
    }

    private long solve(int[] firstStart, int[] firstDur,
                       int[] secondStart, int[] secondDur) {

        int m = secondStart.length;

        int[][] rides = new int[m][2];
        for (int i = 0; i < m; i++) {
            rides[i][0] = secondStart[i];
            rides[i][1] = secondDur[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[m];
        long[] prefixMinDur = new long[m];
        long[] suffixMinFinish = new long[m];

        for (int i = 0; i < m; i++) {
            starts[i] = rides[i][0];
        }

        prefixMinDur[0] = rides[0][1];
        for (int i = 1; i < m; i++) {
            prefixMinDur[i] = Math.min(prefixMinDur[i - 1], rides[i][1]);
        }

        suffixMinFinish[m - 1] =
                (long) rides[m - 1][0] + rides[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            suffixMinFinish[i] = Math.min(
                    suffixMinFinish[i + 1],
                    (long) rides[i][0] + rides[i][1]
            );
        }

        long res = Long.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {

            long finishFirst = (long) firstStart[i] + firstDur[i];

            int pos = upperBound(starts, (int) finishFirst);

            long best = Long.MAX_VALUE;

            if (pos > 0) {
                best = Math.min(best,
                        finishFirst + prefixMinDur[pos - 1]);
            }

            if (pos < m) {
                best = Math.min(best,
                        suffixMinFinish[pos]);
            }

            res = Math.min(res, best);
        }

        return res;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}