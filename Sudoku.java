/***********************************************
* Project: 			Sudoku
************************************************
*
* Authors: 		Claire Giry
*				Hans-Peter Hoellwirth
*				Scott Cantisani
*				Simranbir Singh
*				Oana Radu
*
* Creation date:	06.02.2013
* Last updated:		14.02.2013
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
			{4, 0, 0, 0, 8, 0, 5, 0, 6},
			{0, 8, 0, 6, 0, 2, 0, 0, 4},
			{0, 0, 6, 0, 9, 5, 0, 1, 0},
			{0, 9, 1, 0, 0, 0, 0, 4, 0},
			{0, 0, 0, 8, 4, 9, 0, 0, 0},
			{0, 5, 0, 0, 0, 0, 3, 8, 0},
			{0, 7, 0, 5, 2, 0, 8, 0, 0},
			{9, 0, 0, 3, 0, 7, 0, 2, 0},
			{5, 0, 2, 0, 1, 0, 0, 0, 3}
		};

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = temp[i][j];
			}
		}
	}

	public void printBoard () {
		//rough print function! just console for now
		System.out.println("-------------------");
		for (int i = 0; i < 9; i++) {
			System.out.print("|");
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					System.out.print("*");
				} else {
					System.out.print(board[i][j]);
				}

				if (j % 3 == 2) {
					System.out.print("|");
				} else {
					System.out.print(" ");
				}
			}
			if (i % 3 == 2) {
				System.out.println("\n-------------------");
			} else {
				System.out.println();
			}
		}
	}

	public boolean solveBoard () {
		return solveBoard(nextEmpty(0, 0)[0], nextEmpty(0, 0)[1], 1);
	}

	public boolean solveBoard (int i, int j, int n) {

		int[] col = new int[9];
		int[] row = new int[9];
		int[] block = new int[9];

		if (i == 9 && j == 9) {
			//if at end of board, puzzle solved
			return true;
		} else {
			while (n <= 9) {
				col = getCol(j);
				row = getRow(i);
				block = getBlock(i, j);

				if (contains(col, n) || contains(row, n) || contains(block, n)) {
					//find the first possible number for the cell
					n++;
				} else {
					//set the cell to this number
					board[i][j] = n;
					if (solveBoard(nextEmpty(i, j)[0], nextEmpty(i, j)[1], 1)) {
						//if the puzzle is still solvable with this number, return true
						return true;
					} else {
						//if not, try the next possible number for the cell
						board[i][j] = 0;
						return solveBoard(i, j, n+1);
					}
				}
			}
			//if no possible numbers lead to a solution, return false
			return false;
		}
	}

	public int[] nextEmpty (int i, int j) {

		int[] empty = new int[2];

		for (j = j; j < 9; j++) {
			if (board[i][j] == 0) {
				empty[0] = i;
				empty[1] = j;
				return empty;
			}
		}
		for (i = i + 1; i< 9; i++) {
			for (j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					empty[0] = i;
					empty[1] = j;
					return empty;
				}
			}
		}
		empty[0] = 9;
		empty[1] = 9;
		return empty;
	}

	public int[] getCol (int j) {
		int[] col = new int[9];

		for (int i = 0; i < 9; i++) {
			col[i] = board[i][j];
		}
		return col;
	}

	public int[] getRow (int i) {
		return board[i];
	}

	public int[] getBlock (int i, int j) {
		//could use improvement
		int[] block = new int[9];

		i = i - (i % 3);
		j = j - (j % 3);
		int b = 0;

		for (int n = i; n < i+3; n++) {
			for (int m = j; m < j+3; m++) {
				block[b] = board[n][m];
				b++;
			}
		}
		return block;
	}

	public boolean contains (int[] array, int n) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == n) {
				return true;
			}
		}
		return false;
	}

}
