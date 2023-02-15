import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SparseIntMatrix {
    private int numRows;
    private int numCols;
    private int data;
    private MatrixEntry[] rows;
    private MatrixEntry[] cols;

    public SparseIntMatrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        rows = new MatrixEntry[numRows];
        cols = new MatrixEntry[numCols];

    }

    public SparseIntMatrix(int numRows, int numCols, String inputFile){
        this.numRows = numRows;
        this.numCols = numCols;
        rows = new MatrixEntry[numRows];
        cols = new MatrixEntry[numCols];
        File fi = new File(inputFile);
        try {
            Scanner s = new Scanner(fi);
            while (s.hasNextLine()){
                String[] arr = s.nextLine().split(",");
                setElement(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getElement(int row, int col) {
        MatrixEntry current = rows[row];
        int result = 0;
        while(current != null && current.getColumn() != col) {
            current = current.getNextCol();
        }
        if(current!= null && current.getColumn() == col) {
            result = current.getData();
        }
        return result;
    }

    // deal with zero case
    public boolean setElement(int row, int col, int data) {
        if((row >= 0 && row < this.numRows) && (col >= 0 && col < this.numCols)) {
            MatrixEntry newEntry = new MatrixEntry(row, col, data);
            MatrixEntry currentCol = rows[row];
            MatrixEntry currentRow = cols[col];
            MatrixEntry prevCol = null;
            MatrixEntry prevRow = null;
            if (currentCol == null) {
                rows[row] = newEntry;
            } else {
                while (currentCol != null && currentCol.getColumn() < col){
                    prevCol = currentCol;
                    currentCol = currentCol.getNextCol();
                }
                if (prevCol == null) {
                    rows[row] = newEntry;
                }
                else {
                    prevCol.setNextCol(newEntry);
                }

                newEntry.setNextCol(currentCol);
            }
            if (currentRow == null) {
                cols[col] = newEntry;
            } else {
                while (currentRow != null && currentRow.getRow() < row){
                    prevRow = currentRow;
                    currentRow = currentRow.getNextRow();
                }
                if (prevRow == null) {
                    cols[col] = newEntry;
                }
                else {
                    prevRow.setNextRow(newEntry);
                }

                newEntry.setNextRow(currentRow);
            }
            return true;
        }

        return false;
    }

    public boolean removeElement(int row, int col, int data){
        MatrixEntry current = rows[row];
        if((row >= 0 && row < this.numRows) && (col >= 0 && col < this.numCols)) {
            MatrixEntry newEntry = new MatrixEntry(row, col, data);
            MatrixEntry currentCol = rows[row];
            MatrixEntry currentRow = cols[col];
            MatrixEntry prevCol = null;
            MatrixEntry prevRow = null;
            if (currentCol == null) {
                rows[row] = null;
            } else {
                while (currentCol != null && currentCol.getColumn() < col){
                    prevCol = currentCol;
                    currentCol = currentCol.getNextCol();
                }
                if (prevCol == null) {
                    rows[row] = null;
                }
                else {
                    prevCol.setNextCol(null);
                }

                newEntry.setNextCol(null);
            }
            if (currentRow == null) {
                cols[col] = null;
            } else {
                while (currentRow != null && currentRow.getRow() < row){
                    prevRow = currentRow;
                    currentRow = currentRow.getNextRow();
                }
                if (prevRow == null) {
                    cols[col] = null;
                }
                else {
                    prevRow.setNextRow(null);
                }

                newEntry.setNextRow(null);
            }
            return true;
        }

        return false;
    }

    public int getNumCols() {
        return this.numCols;
    }

    public int getNumRows() {
        return this.numRows;
    }

    public boolean plus(SparseIntMatrix otherMat){
        if((otherMat.numRows == this.numRows) && (otherMat.numCols == this.numCols)){
            for(int i = 0; i <this.getNumRows(); i++){
                for (int j = 0; j < this.getNumCols(); j++){
                    int current = this.getElement(i,j);
                    int result = current + otherMat.getElement(i,j);
                    this.setElement(i,j,result);
                }
            }
            return true;
        }
        return false;
    }

    public boolean minus(SparseIntMatrix otherMat){
        if((otherMat.numRows == this.numRows) && (otherMat.numCols == this.numCols)){
            for(int i = 0; i <this.getNumRows(); i++){
                for (int j = 0; j < this.getNumCols(); j++){
                        int current = this.getElement(i,j);
                        int result = current - otherMat.getElement(i,j);
                        this.setElement(i,j,result);
            }
            }
            return true;
        }
        return false;
    }
}
