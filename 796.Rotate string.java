class Solution {

    public boolean rotateString(String s, String goal) {

        // Lengths must be same
        if(s.length() != goal.length()) {
            return false;
        }

        // Check if goal exists in s+s
        String doubled = s + s;

        return doubled.contains(goal);
    }
}