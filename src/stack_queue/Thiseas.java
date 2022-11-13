package stack_queue;

import java.io.*;

public class Thiseas {

	public static void main(String[] args) {
		// Fill maze
		char[][] maze = initMaze(args[0]);
		int n = maze.length, m = maze[0].length;
	}

	public static char[][] initMaze(String file) {
		// Initializes maze from .txt file input
		ReadFileApp reader = new ReadFileApp();
		try {
			reader.ReadFile(file);
		} catch (NullPointerException e) {
			System.out.printf("[Error when reading from file: %s]\nException: [NullPointerExceptior: File ended abruptly]\n", file);
		} catch (Exception e) {
			System.out.printf("[Error when reading from file: %s]\nException: [%s]\n", file, e);
		}
		return reader.getMaze();
	}
}
