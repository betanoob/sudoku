/***********************************************
* Project: 			Sudoku
************************************************
*
* Authors: 		Claire Giry
*			Hans-Peter Hoellwirth
*			Scott Cantisani
*			Simranbir Singh
*
* Creation date:	06.02.2013
* Last updated:		06.02.2013
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
		int[][] temp = {
			{1, 0, 0, 0, 8, 0, 3, 9, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0},
			{0, 9, 7, 3, 6, 0, 8, 5, 0},
			{8, 2, 4, 0, 3, 9, 0, 0, 0},
			{0, 3, 0, 0, 0, 0, 0, 2, 0},
			{0, 0, 0, 4, 5, 0, 9, 8, 3},
			{0, 4, 2, 0, 9, 1, 5, 6, 0},
			{0, 0, 0, 0, 2, 0, 0, 0, 0},
			{0, 7, 1, 0, 4, 0, 0, 0, 8}
		};

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = temp[i][j];
			}
		}
	}

	public void printBoard () {
		//This is only a rough print function for testing whether initBoard() was working -- not done
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				if (board[i][j] == 0) {
					System.out.print("*" + " ");
				} else {
					System.out.print(board[i][j] + " ");
				}

				if (j % 3 == 2) {
					System.out.print("|");
				}
			}
			System.out.println();
			if (i % 3 == 2) {
				System.out.println("---------------------");
			}
		}
	}

	public void solveBoard () {
		// TBD
	}

	public static void main (String[] args) {
		Sudoku sudoku = new Sudoku();
	}

}
