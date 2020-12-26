import java.util.*;

// offset

/**
 * Maze Class
 * 
 */

class Maze {

	private int[][] maze;	// 2 dim array for maze
	private int[][] mark;	// 2 dim array for visit marking
	
	public Maze(int m, int p) {
		maze = new int[m + 2][p + 2];
		mark = new int[m + 2][p + 2];
		for(int i = 0; i < m + 2; i++)
			for(int j = 0; j < p + 2; j++) {
				maze[i][j] = 1;
				mark[i][j] = 0;
			}
	}

	// create the maze structure
	public void SetWall(int i, int j, int val) {
		maze[i][j] = val;
	}


	public void Path(int m, int p) {

		System.out.println("No path in the maze.");


	}

}; 

