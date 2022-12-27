# Maze Solver

*A program that solves mazes by utilizing a backtracking algorithm and custom implementations of data structures (Linked List, Queue, Stack).*

## Screenshots

![image](https://user-images.githubusercontent.com/97695022/206875437-93fc6a95-1301-43f2-bb77-0356ac297d0d.png)

## Description

First, we created our own interface of a Linked List using generics, which is implemented in the `LinkedListImpl` class.

Using this, we created our own Queue and Stack structures, supporting the following methods:
- push()
- pull()
- isEmpty()
- size()

all in constant time.

The input .txt file contains:
- The maze dimensions n X m in the 1st line.
- The maze entrance coordinates in the 2nd line.
- n additional lines, each containing m cells.

The maze is comprised only of '0', '1', and 'E' characters, with 'E' being the maze entrance and appearing only once. When someone enters the maze they can move horizontally and vertically (but not diagonally) in any direction containing zeros. A maze exit is a '0' character on the maze borders (first or last line and first or last row). There can be multiple (or no) exits.

Using a stack and implementing a backtracking algorithm, the program `Thiseas` prints the coordinates of the maze exit found, whereas if there is none, it prints an appropriate message.


## Lessons learned from this project

- How to handle abstract data types efficiently, by creating our own data structures (Linked Lists, Queues, and Stacks).
- Adding error handling for multiple situations.
- Replacing a recursive approach with an iterative one.
- Creating JUnit testing for our custom data structures.

## Creators

- Katerina Mantaraki [@katerinamant](https://github.com/katerinamant)
- Alex Papadopoulos [@alexisthedev](https://github.com/alexisthedev)
