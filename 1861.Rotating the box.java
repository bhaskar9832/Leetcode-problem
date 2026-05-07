class Solution {

    public char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // STEP 1: Simulate gravity (stones move right)
        for(int i = 0; i < m; i++) {

            int emptyPos = n - 1;

            for(int j = n - 1; j >= 0; j--) {

                // Obstacle found
                if(boxGrid[i][j] == '*') {

                    emptyPos = j - 1;
                }

                // Stone found
                else if(boxGrid[i][j] == '#') {

                    boxGrid[i][j] = '.';
                    boxGrid[i][emptyPos] = '#';

                    emptyPos--;
                }
            }
        }

        // STEP 2: Rotate matrix clockwise
        char[][] result = new char[n][m];

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return result;
    }
}