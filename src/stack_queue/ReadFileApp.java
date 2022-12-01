package stack_queue;

import java.io.*;
import java.util.Arrays;

public class ReadFileApp {
	/*
	 * Reading a nXm grid from a file
	 * First line: grid dimensions (n, m)
	 * Second line: coordinates of maze entrance
	 */
	private int n, m;
	private int entrance_x, entrance_y;
	private char[][] maze;

	public void ReadFile(String file) throws Exception {
		BufferedReader reader = null;
		System.out.printf("[Reading from file: %s]\n", file);
		int linenum = 0;
		reader = new BufferedReader(new FileReader(file));
		String line;

		// Read Maze Dimensions and Entrance Coordinates
		// Both stored in lines with format: "intA intB"
		int[][] mazeData = new int[2][2];
		for (int i=0; i<2; i++) {
			line = reader.readLine();
			linenum++;
			while (line.length() == 0) {
				// Skip empty lines
				System.out.printf("Empty line found. Ignoring line %d...\n", linenum);
				line = reader.readLine();
				linenum++;
			}
			line.trim();
			String split[] = line.split(" ");
			if (split.length != 2) {
				reader.close();
				throw new IOException(String.format("[Error when reading from file: %s]\n"
						+ "Line %d - Invalid maze data", file, linenum));
			}
			mazeData[i][0] = Integer.parseInt(split[0]);
			mazeData[i][1] = Integer.parseInt(split[1]);
		}

		n = mazeData[0][0];
		m = mazeData[0][1];
		entrance_x = mazeData[1][0];
		entrance_y = mazeData[1][1];

		// Initialize maze array
		maze = new char[n][m];

		// Read maze content
		int i = 0;

		// Read all maze rows
		while (i<n) {
			line = reader.readLine();
			linenum++;
			while (line.length() == 0) {
				// Skip empty lines
				System.out.printf("Empty line found. Ignoring line %d...\n", linenum);
				line = reader.readLine();
				linenum++;
			}

			// Read all cells inside a maze row
			line.trim();
			char[] cells = line.toCharArray();
			int j = 0;
			for (char c : cells) {
				if (c == ' ') {
					continue;
				}
				// Store cell and increment j
				if (c != '0' && c != '1' && c != 'E') {
					reader.close();
					throw new IOException(String.format(
							"[Error when reading from file: %s]\n"
									+ "Line %d - Invalid maze content ('%c' is not a valid cell)",
									file, linenum, c));
				}

				// Check that row does not have extra cells
				if (j >= m) {
					reader.close();
					throw new IOException(String.format(
							"[Error when reading from file: %s]\n"
									+ "Line %d - Exceeded maze dimensions (Row %d already has %d cells)",
									file, linenum, i, m));
				}

				maze[i][j++] = c;
			}

			// Check that row does not have less cells than expected
			if (j < m) {
				reader.close();
				throw new IOException(String.format(
						"[Error when reading from file: %s]\n"
								+ "Line %d - Invalid maze content (Expected %d cells in row %d, found %d)",
								file, linenum, m, i, j));
			}

			// Increment row count
			i++;
		}

		// Check if entrance is at given coordinates
		if (maze[entrance_x][entrance_y] != 'E') {
			reader.close();
			throw new IOException(
					String.format(
							"[Error when reading from file: %s]\n"
									+ "Invalid maze entrance coordinates (expected 'E' at (%d, %d), '%c' found)",
									file, entrance_x, entrance_y,
									maze[entrance_x][entrance_y]));
		}

		// Check for extra lines at end of file
		while ( (line = reader.readLine()) != null) {
			linenum++;
			if (line.length() != 0) {
				reader.close();
				throw new IOException(String.format(
						"[Error when reading from file: %s]\n"
								+ "Line %d - More data than expected",
								file, linenum));
			}
		}
		reader.close();
		System.out.printf("[Succesfully read from file: %s]\n\n", file);
	}

	public char[][] getMaze() {
		char[][] res = new char[n][m];
		for (int i=0; i<n; i++) {
			res[i] = Arrays.copyOf(maze[i], m);
		}
		return res;
	}

	public int[] getDimensions() {
		return new int[] {n, m};
	}

	public int[] getEntrance() {
		return new int[] {entrance_x, entrance_y};
	}
}
