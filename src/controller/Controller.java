package controller;

import view.View;
import application.MazeDisplayer;
import javafx.scene.input.KeyCode;
import logic.Maze;


public class Controller {
	private Maze logic;
	private MazeDisplayer view;
	
	public Controller() {
		logic = new Maze();
		view = new MazeDisplayer();
	}
	
	public void setMazeDataFromUI(int[][] table) {
		logic.setMazeData(table);
	}
	
	public boolean moveCharcterPositionFromUI(int row,int col) {
		return logic.moveCharacter(row,col);
	}
	
	public void charcterPositionChangedFromModel(int row,int col) {
		view.setCharcterPosition(row,col);
	}
}
