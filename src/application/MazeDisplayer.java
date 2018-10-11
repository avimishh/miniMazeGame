package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MazeDisplayer extends Canvas {

	public MazeDisplayer() {
		chooseCharacter();
	}

	private int[][] mazeData;

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
		redraw();
	}

	private int cRow;
	private int cCol;
	private int initialCRow;
	public void setCharcterPosition(int row, int col) {

		setcRow(row);
		setcCol(col);
		redraw();
	}

	public void redraw() {
		if (mazeData != null) {
			double tableWidth = getWidth();
			double tableHeight = getHeight();
			double w = tableWidth / mazeData[0].length;
			double h = tableHeight / mazeData.length;

			GraphicsContext gc = getGraphicsContext2D();

			for (int i = 0; i < mazeData.length; i++) {
				for (int j = 0; j < mazeData[i].length; j++) {
					gc.clearRect(w * j, h * i, w, h);
					if (mazeData[i][j] == 1)
						// gc.drawImage(ground, w*j, h*i, w, h);
						gc.fillRect(w * j, h * i, w, h);
					else if (mazeData[i][j] == 0)
						gc.drawImage(grass, w * j, h * i, w, h);
				}
			}
			gc.drawImage(character, w * getcCol(), h * getcRow(), w, h);

		}
	}

	private Image character;
	private Image grass;

	public void chooseCharacter() {
		try {
			character = new Image(new FileInputStream("./resources/donk.png"));
			grass = new Image(new FileInputStream("./resources/grass.jpg"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getcRow() {
		return cRow;
	}

	public void setcRow(int cRow) {
		this.cRow = cRow;
	}

	public int getcCol() {
		return cCol;
	}

	public void setcCol(int cCol) {
		this.cCol = cCol;
	}

	public int getInitialCRow() {
		return initialCRow;
	}

	public void setInitialCRow(int initialCRow) {
		this.initialCRow = initialCRow;
	}

}
