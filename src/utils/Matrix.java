package utils;

public class Matrix {
  private int[][] data;
  
  public Matrix(int rows, int columns) {
    this.data = new int[rows][columns];
  }

  public void setValue(int row, int column, int value) {
    this.data[row][column] = value;
  }

  public int getValue(int row, int column) {
    return this.data[row][column];
  }

  public int deleteValue(int row, int column) {
    return this.data[row][column] = 0;
  }

  public void setRow(int row, int[] rowValues) {
    this.data[row] = rowValues;
  }

  public int rows() {
    return this.data.length;
  }

  public int columns() {
    return this.data[0].length;
  }

  public String toString() {
    StringBuilder text = new StringBuilder();

    for (int[] row : this.data) {
      for (int column : row) {
        text.append("| " + column + " |");
      }

      text.append("\n");
    }
    
    return text.toString();
  }
}