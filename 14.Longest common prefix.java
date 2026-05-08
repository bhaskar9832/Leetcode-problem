class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // Find the shortest string
        String shortest = strs[0];
        for (String s : strs) {
            if (s.length() < shortest.length()) {
                shortest = s;
            }
        }

        for (int i = 0; i < shortest.length(); i++) {
            char ch = shortest.charAt(i);

            for (String s : strs) {
                if (s.charAt(i) != ch) {
                    return shortest.substring(0, i);
                }
            }
        }

        return shortest;
    }
}
