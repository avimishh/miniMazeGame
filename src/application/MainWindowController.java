package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import controller.Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class MainWindowController implements Initializable {
	private Controller controller;

	/*
	 * int[][] mazeArray= { {1,1,1,1,1}, {0,0,1,0,0}, {1,0,1,0,1}, {1,0,0,0,1},
	 * {1,1,1,1,1} };
	 */
	@FXML
	MazeDisplayer mazeDisplayer;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		controller = new Controller();
		readLevelFromFile(new File("./resources/levels/level1.txt")); // default
		mazeDisplayer.addEventFilter(MouseEvent.MOUSE_CLICKED, (e) -> mazeDisplayer.requestFocus());
		mazeDisplayer.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				int r = mazeDisplayer.getcRow();
				int c = mazeDisplayer.getcCol();

				if (event.getCode() == KeyCode.UP) {
					if (controller.moveCharcterPositionFromUI(r - 1, c))
						mazeDisplayer.setCharcterPosition(r - 1, c);
				}
				if (event.getCode() == KeyCode.DOWN) {
					if (controller.moveCharcterPositionFromUI(r + 1, c))
						mazeDisplayer.setCharcterPosition(r + 1, c);
				}
				if (event.getCode() == KeyCode.LEFT) {
					if (controller.moveCharcterPositionFromUI(r, c - 1))
						mazeDisplayer.setCharcterPosition(r, c - 1);
				}
				if (event.getCode() == KeyCode.RIGHT) {
					if (controller.moveCharcterPositionFromUI(r, c + 1))
						mazeDisplayer.setCharcterPosition(r, c + 1);
				}
			}

		});
	}

	public void start() {
		readLevel();
	}
	
	public void restart() {
		mazeDisplayer.setCharcterPosition(mazeDisplayer.getInitialCRow(),0);
	}
	
	public void readLevel() {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("./resources/levels"));
		fc.setTitle("Choose level");
		File level = fc.showOpenDialog(null);

		if (level != null) {
			readLevelFromFile(level);
		}
	}

	public void readLevelFromFile(File level) {
		int[][] table = new int[5][5];
		Scanner reader = null;
		try {
			reader = new Scanner(new BufferedReader(new FileReader(level)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (reader.hasNext()) {
			for (int i = 0; i < table.length; i++) {
				String[] line = reader.nextLine().trim().split(" ");
				for (int j = 0; j < line.length; j++) {
					table[i][j] = Integer.parseInt(line[j]);
					if (table[i][j] == 2) {
						mazeDisplayer.setcRow(i);
						mazeDisplayer.setcCol(j);
						mazeDisplayer.setInitialCRow(i);
					}
				}
			}
		}

		mazeDisplayer.setMazeData(table);
		controller.setMazeDataFromUI(table);
	}

}
