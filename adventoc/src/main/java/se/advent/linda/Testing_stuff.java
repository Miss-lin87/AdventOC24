package se.advent.linda;

import java.util.LinkedList;
import java.util.Queue;

public class Testing_stuff {
    int minDistance(char[][] grid, int line, int row){
        Cords start = new Cords(line, row, 0);
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        
        // applying BFS on matrix cells starting from source
        Queue<Cords> queue = new LinkedList<>();
        queue.add(new Cords(start.line = line, start.row = row, 0));
    
        seen[start.line][start.row] = true;
    
        while (queue.isEmpty() == false) {
        Cords p = queue.remove();
        
        // Destination found;
        if (grid[p.line][p.row] == 'd')
            return p.distance;
    
        // moving up
        if (isValid(p.line - 1, p.row, grid, seen)) {
            queue.add(new Cords(p.line - 1, p.row,
                                p.distance + 1));
            seen[p.line - 1][p.row] = true;
        }
    
        // moving down
        if (isValid(p.line + 1, p.row, grid, seen)) {
            queue.add(new Cords(p.line + 1, p.row,
                                p.distance + 1));
            seen[p.line + 1][p.row] = true;
        }
    
        // moving left
        if (isValid(p.line, p.row - 1, grid, seen)) {
            queue.add(new Cords(p.line, p.row - 1,
                                p.distance + 1));
            seen[p.line][p.row - 1] = true;
        }
    
        // moving right
        if (isValid(p.line, p.row + 1, grid, seen)) {
            queue.add(new Cords(p.line, p.row + 1,
                                p.distance + 1));
            seen[p.line][p.row + 1] = true;
        }
        }
        return -1;
    }

    boolean isValid(int line, int row, char[][] grid, boolean[][] visited) {
    if (line >= 0 && row >= 0 && line < grid.length && row < grid[0].length && grid[line][row] != '0' && visited[line][row] == false) {
        return true;
        }
    return false;
    }

    public static void main(String[] args) {
        Testing_stuff test = new Testing_stuff();
        /*package whatever //do not write package name here */
// Java Code implementation for above problem
char[][] grid = { { '0', '*', '0','*', 's' },
                  { '*', '*', '*','0', '*' },
                  { '*', '*', '*','0', '*' },
                  { '*', '0', '*','0', '*' },
                  { '*', '0', '*','0', '*' },
                  { 'd', '0', '*','*', '*' } };

System.out.println(test.minDistance(grid, 0, 4));
}
}