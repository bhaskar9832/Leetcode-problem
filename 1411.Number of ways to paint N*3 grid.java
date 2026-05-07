class Solution {

    public int numOfWays(int n) {

        long aba = 6;
        long abc = 6;

        int MOD = 1000000007;

        for(int i = 2; i <= n; i++) {

            long newAba = (3 * aba + 2 * abc) % MOD;

            long newAbc = (2 * aba + 2 * abc) % MOD;

            aba = newAba;
            abc = newAbc;
        }

        return (int)((aba + abc) % MOD);
    }
}