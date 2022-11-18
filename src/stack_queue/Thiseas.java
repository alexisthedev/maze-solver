package stack_queue;

import java.util.ArrayList;

public class Thiseas {
	static ReadFileApp reader = new ReadFileApp();

	public static void main(String[] args) throws Exception {
		// Read file input
		try {
			reader.ReadFile(args[0]);
		} catch (NullPointerException e) {
			throw new NullPointerException(String.format("[Error when reading from file: %s]\n"
					+ "\nFile ended abruptly\n",
					args[0]));
		}

		int[] exit = findExit();
		if (exit[0] == -1) {
			System.out.println("It's a trap! There is no way for Theseus to exit this maze.");
			return;
		}
		System.out.printf("\n\nHooray! Theseus has managed to escape through the exit at (%d, %d)!\nSuck it Minotaur.\n", exit[0], exit[1]);
	}

	public static int[] findExit() {
		// Get maze
		char[][] maze = reader.getMaze();

		// Get maze dimensions
		int n = reader.getDimensions()[0], m = reader.getDimensions()[1];

		// Get maze entrance coordinates
		int e_x = reader.getEntrance()[0], e_y = reader.getEntrance()[1];

		int x = e_x; int y = e_y;
		StackStruct<int[]> path = new StackStruct<int[]>();
		path.push(new int[] {e_x, e_y});
		while (true) {
			// Check if we have reached an exit
			if (maze[x][y] == '0' && checkEdges(x, y, n, m)) {
				maze[x][y] = '*';
				printMaze(maze);
				return new int[] {x, y};
			}

			if(maze[x][y] != 'E') maze[x][y] = '*';

			// Checks neighboring cells to find unvisited paths
			ArrayList<int[]> neighbors = getNeighbors(maze, x, y, n, m);
			if (neighbors.size() == 0 && !path.isEmpty()) {
				x = path.peek()[0];
				y = path.peek()[1];
				path.pop();
			} else if (neighbors.size() == 0 && path.isEmpty()){
				break;
			} else if (neighbors.size() > 1) {
				path.push(new int[] {x, y});
				x = neighbors.get(0)[0];
				y = neighbors.get(0)[1];
			} else {
				x = neighbors.get(0)[0];
				y = neighbors.get(0)[1];
			}
		}

		return new int[] {-1, -1};
	}

	public static ArrayList<int[]> getNeighbors(char[][] maze, int x, int y, int n, int m) {
		ArrayList<int[]> neighbors = new ArrayList<int[]>();
		if (x != 0 && maze[x-1][y] == '0')
			neighbors.add(new int[] {x-1, y});
		if (y != m-1 && maze[x][y+1] == '0')
			neighbors.add(new int[] {x, y+1});
		if (x != n-1 && maze[x+1][y] == '0')
			neighbors.add(new int[] {x+1, y});
		if (y != 0 && maze[x][y-1] == '0')
			neighbors.add(new int[] {x, y-1});

		return neighbors;
	}

	public static boolean checkEdges(int x, int y, int n, int m) {
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