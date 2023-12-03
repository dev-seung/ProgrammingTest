package Test;

public class No5 {
    public static void main(String[] args) {
        int[][] pond = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        int totalDepth = calculateTotalDepth(pond);
        System.out.println("총합: " + totalDepth);
    }

    private static int calculateTotalDepth(int[][] pond) {
        boolean updated;
        do {
            updated = false;
            for (int i = 1; i < pond.length - 1; i++) {
                for (int j = 1; j < pond[i].length - 1; j++) {
                    if (canIncreaseDepth(pond, i, j)) {
                        pond[i][j]++;
                        updated = true;
                    }
                }
            }
        } while (updated);

        int totalDepth = 0;
        for (int[] row : pond) {
            for (int depth : row) {
                totalDepth += depth;
            }
        }
        return totalDepth;
    }

    private static boolean canIncreaseDepth(int[][] pond, int i, int j) {
        int current = pond[i][j];
        return pond[i - 1][j] >= current && pond[i + 1][j] >= current &&
               pond[i][j - 1] >= current && pond[i][j + 1] >= current;
    }
}

