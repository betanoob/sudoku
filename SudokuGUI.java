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
* Creation date:	14.02.2013
* Last updated:		14.02.2013
***********************************************/
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SudokuGUI extends Frame {

	private Sudoku sudoku = new Sudoku();
	private Panel panel = new Panel();

	public SudokuGUI () {
		initWindow();
	}

	public void initWindow () {
	    setTitle("Sudoku");
    	setSize(200,200);
    	addWindowListener(new SudokuWindowListener());
		drawPanel();
		setVisible(true);
	}

	public void drawPanel () {

	}

  	class SudokuWindowListener extends WindowAdapter
  	{
    	public void windowClosing (WindowEvent e)
    	{
    		e.getWindow().dispose();
      		System.exit(0);
    	}
  	}

	public static void main (String[] args) {
		new SudokuGUI();
	}
}