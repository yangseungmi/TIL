/*
994. Rotting Oranges
https://leetcode.com/problems/rotting-oranges/

Queue에 대해 공부가 매우 필요해서 이번 기회에 다시 정리해보면서 풀어보았다.
Queue, Array, 상태별 조건
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : DIRS) {
                    int nextX = curr[0] + dir[0];
                    int nextY = curr[1] + dir[1];
                    if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || grid[nextX][nextY] != 1) {
                        continue;
                    }
                    queue.offer(new int[]{nextX, nextY});
                    grid[nextX][nextY] = 2;
                    freshCount--;
                }
            }

            step++;
        }

        return freshCount == 0 ? step : -1;
    }
}
