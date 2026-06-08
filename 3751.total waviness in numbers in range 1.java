class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int x = num1; x <= num2; x++) {
            ans += waviness(x);
        }

        return ans;
    }

    private int waviness(int x) {
        char[] d = String.valueOf(x).toCharArray();

        if (d.length < 3) return 0;

        int cnt = 0;

        for (int i = 1; i < d.length - 1; i++) {
            if ((d[i] > d[i - 1] && d[i] > d[i + 1]) ||
                (d[i] < d[i - 1] && d[i] < d[i + 1])) {
                cnt++;
            }
        }

        return cnt;
    }
}