package logic;

public class Maze {

	private int cRow;
	private int cCol;

	public boolean moveCharacter(int row, int col) {
		if (row >= mazeData.length || col >= mazeData[0].length || row < 0 || col < 0)
			return false;
		if (mazeData[row][col] == 0) {
			setcRow(row);
			setcCol(col);
			return true;
		} else
			return false;
	}

	private int[][] mazeData;

	public void setMazeData(int[][] mazeData) {
		this.mazeData = mazeData;
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
}
