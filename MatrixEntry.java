public class MatrixEntry {
    private int row;
    private int col;
    private int data;
    private MatrixEntry nextRow;
    private MatrixEntry nextCol;

    public MatrixEntry(int row, int col, int data){
        this.row = row;
        this.col = col;
        this.data = data;
    }

    public MatrixEntry(int row, int col, int data, MatrixEntry nextRow, MatrixEntry nextCol){
        this.row = row;
        this.col = col;
        this.data = data;
        this.nextRow = nextRow;
        this.nextCol = nextCol;
    }

    public int getColumn() {
        return this.col;
    }

    public void setColumn(int col) {
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MatrixEntry getNextRow(){
        return this.nextRow;
    }

    public void setNextRow(MatrixEntry el){
        this.nextRow = el;
    }

    public MatrixEntry getNextCol(){
        return this.nextCol;
    }

    public void setNextCol(MatrixEntry el){
        this.nextCol = el;
    }
}
