
import java.util.*;

// offset

class offsets {
	int a, b;
	public offsets(int a, int b) {
		this.a = a;
		this.b = b;
		}
};

class Maze {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> dir = new Stack<>();

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
		offsets[] move = {
				 new offsets(1, 0),// S
				 new offsets(1, -1),// SW
				 new offsets(0, -1), // W
				 new offsets(-1, -1), // NW
				 new offsets(-1, 0), // N
				 new offsets(-1, 1), // NE
				 new offsets(0, 1), // E
				 new offsets(1, 1) // SE
				};

		int i = 1;
		int j = 1;
		int d = 0;
		int t = 0;
		
		Stack<Integer> stack = new Stack<>();
		
		while(true) {
			if(i == m && j == p) {
				stack.push(i);
				stack.push(j);
				dir.push(d);
				break;
			}
			while(true) {
				if(d == 8) {
					d = (dir.pop() + 4) % 8;
					while(true) {
						int g = i + move[d].a;
						int h = j + move[d].b;
						if(maze[g][h] == 0 && mark[g][h] == 1) {
							stack.pop();
							stack.pop();
							maze[i][j] = 1;
							i = g;
							j = h;
							d = 0;
							break;
						}
						else {
							d+=1;
						}
					}
				}
				int g = i + move[d].a;
				int h = j + move[d].b;
				if(maze[g][h] == 0 && mark[g][h] == 0) {
					stack.push(i);
					stack.push(j);
					dir.push(d);
					mark[i][j] = 1;
					i = g;
					j = h;
					d = 0;
					break;
				}
				else{
					d += 1;
				}
			}
			
		}
		ArrayList array = new ArrayList();
		
		while(stack.empty()==false) {
			int a = stack.pop();
			int b = stack.pop();
			array.add(b);
			array.add(a);
		}
	    for (int z = array.size()-1; 0 <= z; z-=2) {
	    	System.out.print("(");
			System.out.print(array.get(z-1));
			System.out.print(",");
			System.out.print(array.get(z));
			System.out.print(")");
			System.out.println();
	    }
	}
};


