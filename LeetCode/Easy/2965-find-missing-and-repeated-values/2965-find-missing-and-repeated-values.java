class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int N = grid.length * grid.length;
        long actualSum = 0, actualSquareSum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int val = grid[i][j];
                actualSum += val;
                actualSquareSum += (long) val * val;
            }
        }

        long expectedSum = (long) N * (N + 1) / 2;
        long expectedSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long diff = actualSum - expectedSum; // x - y
        long sumDiff = (actualSquareSum - expectedSquareSum) / diff; // x + y

        int repeated = (int)((diff + sumDiff) / 2);
        int missing = (int)(repeated - diff);

        return new int[]{repeated, missing};
    }
}

