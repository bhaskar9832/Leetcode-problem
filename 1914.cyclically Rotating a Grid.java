import java.util.*;

class Solution {

    public int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // Top row
            for (int j = left; j <= right; j++) {
                elements.add(grid[top][j]);
            }

            // Right column
            for (int i = top + 1; i < bottom; i++) {
                elements.add(grid[i][right]);
            }

            // Bottom row
            for (int j = right; j >= left; j--) {
                elements.add(grid[bottom][j]);
            }

            // Left column
            for (int i = bottom - 1; i > top; i--) {
                elements.add(grid[i][left]);
            }

            int size = elements.size();
            int rotate = k % size;

            List<Integer> rotated = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                rotated.add(elements.get((i + rotate) % size));
            }

            int idx = 0;

            // Put back Top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = rotated.get(idx++);
            }

            // Put back Right column
            for (int i = top + 1; i < bottom; i++) {
                grid[i][right] = rotated.get(idx++);
            }

            // Put back Bottom row
            for (int j = right; j >= left; j--) {
                grid[bottom][j] = rotated.get(idx++);
            }

            // Put back Left column
            for (int i = bottom - 1; i > top; i--) {
                grid[i][left] = rotated.get(idx++);
            }
        }

        return grid;
    }
}