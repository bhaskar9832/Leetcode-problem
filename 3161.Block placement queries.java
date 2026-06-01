import java.util.*;

class Solution {

    class SegmentTree {
        int n;
        int[] tree;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) >> 1;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, val);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, val);
            }

            tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }

            if (l <= start && end <= r) {
                return tree[node];
            }

            int mid = (start + end) >> 1;

            return Math.max(
                query(node * 2, start, mid, l, r),
                query(node * 2 + 1, mid + 1, end, l, r)
            );
        }
    }

    public List<Boolean> getResults(int[][] queries) {

        final int MAX = 50000;

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(MAX);

        SegmentTree seg = new SegmentTree(MAX + 1);

        seg.update(1, 0, MAX, MAX, MAX);

        List<Boolean> answer = new ArrayList<>();

        for (int[] q : queries) {

            if (q[0] == 1) {

                int x = q[1];

                int right = obstacles.ceiling(x);
                int left = obstacles.floor(x);

                obstacles.add(x);

                seg.update(1, 0, MAX, x, x - left);
                seg.update(1, 0, MAX, right, right - x);

            } else {

                int x = q[1];
                int sz = q[2];

                int obstacle = obstacles.floor(x);

                int best = 0;

                if (obstacle > 0) {
                    best = seg.query(1, 0, MAX, 0, obstacle);
                }

                best = Math.max(best, x - obstacle);

                answer.add(best >= sz);
            }
        }

        return answer;
    }
}