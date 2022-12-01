package stack_queue;

public class Thiseas {
	static ReadFileApp reader = new ReadFileApp();

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
		char[][] maze = reader.getMaze();

		// Get maze dimensions
		int n = reader.getDimensions()[0], m = reader.getDimensions()[1];

		// Get maze entrance coordinates
		int e_x = reader.getEntrance()[0], e_y = reader.getEntrance()[1];

		StackStruct<int[]> path = new StackStruct<int[]>(new int[] {e_x, e_y});
		while (!path.isEmpty()) {
			// Get current position from stack's top
			int x = path.peek()[0], y = path.peek()[1];

			// Check if we have reached an exit
			if (maze[x][y] == '0' && checkEdges(x, y, n, m)) {
				// Keep exit coordinates
				int[] exit = {x, y};

				// Get copy of maze
				char[][] mazeCopy = reader.getMaze();

				// Mark exit path with *
				while (!path.isEmpty()) {
					x = path.peek()[0];
					y = path.peek()[1];
					mazeCopy[x][y] = '*';
					path.pop();
				}

				// Mark entrance as E and not as *
				mazeCopy[e_x][e_y] = 'E';

				// Print the maze that only shows the exit path
				// and return the exit coordinates
				printMaze(mazeCopy);
				return exit;
			}

			maze[x][y] = '*';

			// Checks neighboring cells to find unvisited paths
			if (x != 0 && maze[x-1][y] == '0') {
				path.push(new int[] {x-1, y});
			} else if (y != m-1 && maze[x][y+1] == '0') {
				path.push(new int[] {x, y+1});
			} else if (x != n-1 && maze[x+1][y] == '0') {
				path.push(new int[] {x+1, y});
			} else if (y != 0 && maze[x][y-1] == '0') {
				path.push(new int[] {x, y-1});
			} else {
				path.pop();
				maze[x][y] = '1';
			}

		}

		return new int[] {-1, -1};
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