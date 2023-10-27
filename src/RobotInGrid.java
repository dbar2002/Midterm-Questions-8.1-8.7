//8.2 Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
//The robot can only move in two directions, right and down, but certain cells are "off limits" such that
//the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
//the bottom right.

import java.util.ArrayList;
import java.util.List;

public class RobotInGrid {
    public static List<Position> findPath(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        List<Position> path = new ArrayList<>();
        boolean[][] visited = new boolean[numRows][numCols];

        if (findPath(grid, numRows - 1, numCols - 1, path, visited)) {
            return path;
        }

        return null;
    }

    private static boolean findPath(int[][] grid, int row, int col, List<Position> path, boolean[][] visited) {
        if (row < 0 || col < 0 || grid[row][col] == 1 || visited[row][col]) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || findPath(grid, row - 1, col, path, visited) || findPath(grid, row, col - 1, path, visited)) {
            Position position = new Position(row, col);
            path.add(position);
            return true;
        }

        visited[row][col] = true;
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };

        List<Position> path = findPath(grid);

        if (path != null) {
            System.out.println("Path found:");
            for (Position p : path) {
                System.out.println("(" + p.row + ", " + p.col + ")");
            }
        } else {
            System.out.println("No valid path found.");
        }
    }
}

class Position {
    int row;
    int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
