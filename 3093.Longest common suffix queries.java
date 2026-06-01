class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // best index for this node
        int idx = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    private void update(TrieNode node, int index, int length) {
        if (length < node.len ||
           (length == node.len && index < node.idx)) {

            node.len = length;
            node.idx = index;
        }
    }

    private void insert(String word, int index) {

        TrieNode node = root;

        update(node, index, word.length());

        for (int i = word.length() - 1; i >= 0; i--) {

            int c = word.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            update(node, index, word.length());
        }
    }

    private int search(String query) {

        TrieNode node = root;

        for (int i = query.length() - 1; i >= 0; i--) {

            int c = query.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer,
                               String[] wordsQuery) {

        int n = wordsContainer.length;

        for (int i = 0; i < n; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}