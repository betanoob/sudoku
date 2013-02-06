/***********************************************
* Project: 			Sudoku
************************************************
*
* Authors: 			Claire Giry
*					Hans-Peter Hoellwirth
*					Scott Cantisani
*					Simranbir Singh
*
* Creation date:	06.02.2013
* Last updated:     06.02.2013
***********************************************/
public class Sudoku {

	private int[][] board = new int[9][9];

	public Sudoku () {
		initBoard();
		printBoard();
		System.out.println();
		solveBoard();
		printBoard();
	}

	public void initBoard () {
		// TBD
	}

	public void printBoard () {
		// TBD
	}

	public void solveBoard () {
		// TBD
	}

	public static void main (String[] args) {
		Sudoku sudoku = new Sudoku();
	}

}