package stack_queue;

import java.util.*;
import java.io.*;

public class ReadFileApp {
	/*
	 * Reading a nXm grid from a file
	 * First line: grid dimensions (n, m)
	 * Second line: coordinates of maze entrance
	 */
	private int n, m;
	private int entrance_x, entrance_y;
	private int[][] maze;

	public void ReadFile(String file) {
		BufferedReader reader = null;
		System.out.printf("[Reading from file: %s]\n", file);

		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			int linenum = 0;

			// Read Maze Dimensions and Entrance Coordinates
			// Both stored in lines with format: "intA intB"
			int[][] mazeData = new int[2][2];
			for (int i=0; i<2; i++) {
				line = reader.readLine();
				linenum++;
				while (line == null) {
					// Skip empty lines
					System.out.printf("Empty line found. Ignoring line %d...", linenum);
					line = reader.readLine();
					linenum++;
				}
				line.trim();
				String split[] = line.split(" ");
				if (split.length != 2) {
					reader.close();
					throw new IOException(String.format("Error at line %d when reading maze data", linenum));
				}
				mazeData[i][0] = Integer.parseInt(split[0]);
				mazeData[i][1] = Integer.parseInt(split[1]);
			}

			n = mazeData[0][0];
			m = mazeData[0][1];
			entrance_x = mazeData[1][0];
			entrance_y = mazeData[1][1];

			// Read Maze Contents

			// Pad Maze with -1s
			maze = new int[n+2][m+2];

			reader.close();
		} catch (IOException e) {
			System.out.printf("[Error when reading from file: %s]\nException: [%s]", file, e);
		} catch (NumberFormatException e) {
			System.out.printf("[Error when reading from file: %s]\nException: [%s]", file, e);
		}
	}
}
