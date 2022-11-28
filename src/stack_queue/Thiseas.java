package stack_queue;

import java.util.ArrayList;

public class Thiseas {
	static ReadFileApp reader = new ReadFileApp();
	static char[][] maze;
	static int n, m;

	public static void main(String[] args) throws Exception {
		// Read file input
		try {
			reader.ReadFile(args[0]);
		} catch (NullPointerException e) {
			/* Other errors are handled and thrown with custom messages
			 * inside of the ReadFileApp class.
			 * If an error is caught here, then the only case left
			 * is an early end of file (EOF) when we expect more data.
			 */
			throw new NullPointerException(String.format("[Error when reading from file: %s]\n"
					+ "\nFile ended abruptly\n",
					args[0]));
		}

		// Get maze exit coordinates
		int[] exit = findExit();
		if (exit[0] == -1) {
			// Check for flag (-1) indicating that there is no exit
			System.out.println("It's a trap! There is no way for Theseus to exit this maze.");
			return;
		}

		System.out.printf("\n\nHooray! Theseus has managed to escape through the exit at (%d, %d)!\nSuck it Minotaur.\n", exit[0], exit[1]);
	}

	public static int[] findExit() {
		// Get maze
		maze = reader.getMaze();

		// Get maze dimensions
		n = reader.getDimensions()[0]; m = reader.getDimensions()[1];

		// Get maze entrance coordinates
		int e_x = reader.getEntrance()[0], e_y = reader.getEntrance()[1];

		// Start searching for an exit at the entrance
		int x = e_x; int y = e_y;

		// Initialize a stack to keep our path coordinates
		StackStruct<int[]> path = new StackStruct<int[]>();

		// Initialize a list to keep accessable neighbor cells
		// Initialized with the neighbors of the entrance cell
		ArrayList<int[]> neighbors = getNeighbors(maze, x, y);
		while (neighbors.size()!= 0 || !path.isEmpty()) {
			// Check if we have reached an exit
			if (maze[x][y] == '0' && checkLimits(x, y)) {
				maze[x][y] = '*';
				printMaze(maze);
				return new int[] {x, y};
			}

			// Mark the current cell as visited
			maze[x][y] = '*';

			// Checks neighboring cells to find unvisited paths
			if (neighbors.size() == 0) {
				x = path.peek()[0];
				y = path.peek()[1];
				path.pop();
			} else if (neighbors.size() > 1) {
				path.push(new int[] {x, y});
				x = neighbors.get(0)[0];
				y = neighbors.get(0)[1];
			} else {
				x = neighbors.get(0)[0];
				y = neighbors.get(0)[1];
			}
			neighbors = getNeighbors(maze, x, y);
		}

		return new int[] {-1, -1};
	}

	public static ArrayList<int[]> getNeighbors(char[][] maze, int x, int y) {
		// Returns a list of visitable cell neighbors.
		// A cell is visitable if it is '0' (not '*','1') and
		// if its coordinates are valid (0<=x<=n-1, 0<=y<=m-1)
		ArrayList<int[]> neighbors = new ArrayList<int[]>();
		if (x > 0 && maze[x-1][y] == '0')
			neighbors.add(new int[] {x-1, y});
		if (y < m-1 && maze[x][y+1] == '0')
			neighbors.add(new int[] {x, y+1});
		if (x < n-1 && maze[x+1][y] == '0')
			neighbors.add(new int[] {x+1, y});
		if (y > 0 && maze[x][y-1] == '0')
			neighbors.add(new int[] {x, y-1});
		return neighbors;
	}

	public static boolean checkLimits(int x, int y) {
		// Returns true if (x,y) point to a cell at the maze limits
		return x == 0 || x == n-1 || y == 0 || y == m-1;
	}

	public static void printMaze(char[][] maze) {
		for (int i=0; i<maze.length; i++) {
			for (int j=0; j<maze[0].length; j++) {
				System.out.print(" " + maze[i][j]);
			}
			System.out.print("\n");
		}
	}
}
