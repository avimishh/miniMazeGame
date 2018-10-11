package view;
import controller.Controller;

public class View {
	private Controller controller;
	
	public View() {
		controller = new Controller();
	}
	
	public void setMazeFromUI(int[][] table) {
		controller.setMazeDataFromUI(table);
	}
}
