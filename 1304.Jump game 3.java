class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    private boolean dfs(int[] arr, int index) {
        // Out of bounds or already visited
        if (index < 0 || index >= arr.length || arr[index] < 0) {
            return false;
        }

        // Found target
        if (arr[index] == 0) {
            return true;
        }

        int jump = arr[index];

        // Mark current index as visited
        arr[index] = -arr[index];

        // Try both possible jumps
        return dfs(arr, index + jump) || dfs(arr, index - jump);
    }
}