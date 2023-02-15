public class MatrixEntryTest {
    public static void main(String[] args) {
//        Test of both constructors and setup for the rest of the tests
        MatrixEntry test2 = new MatrixEntry(1,2,7);
        MatrixEntry test3 = new MatrixEntry(2,1,5);
        MatrixEntry test1 = new MatrixEntry(1,1,3,test2,test3);

//        Testing .getData() function
        System.out.println("Testing .getData(): " + test1.getData() + ", expected answer is 3.");

        System.out.println("------------------------------------------------------------------");

//        Testing .getColumn() function
        System.out.println("Testing .getColumn(): " + test1.getColumn() + ", expected answer is 1.");

        System.out.println("------------------------------------------------------------------");

//        Testing .getRow() function
        System.out.println("Testing .getRow(): " + test1.getRow() + ", expected answer is 1.");

        System.out.println("------------------------------------------------------------------");

//        Testing .setColumn() & .setRow() functions
        test1.setColumn(5);
        test1.setRow(4);
        System.out.println("Testing .setColumn(): " + test1.getColumn() + ", expected answer is 5.");
        System.out.println("Testing .setRow(): " + test1.getRow() + ", expected answer is 4.");

        System.out.println("------------------------------------------------------------------");

//        resetting test1 rows and cols for further testing
        test1.setColumn(1);
        test1.setRow(1);

//        Testing .setData() function
        test1.setData(2);
        System.out.println("Testing .setData(): " + test1.getData() + ", expected answer is 2.");

        System.out.println("------------------------------------------------------------------");

//        Testing .getNextRow() & .getNextCol() functions
        System.out.println("Testing .getNextRow(): " + test1.getNextRow().getData() + ", expected answer is 7.");
        System.out.println("Testing .getNextCol(): " + test1.getNextCol().getData() + ", expected answer is 5.");

        System.out.println("------------------------------------------------------------------");

//        Testing .setNextRow() & .setNextCol() function;
        MatrixEntry test4 = new MatrixEntry(1,2,0);
        MatrixEntry test5 = new MatrixEntry(2,1,100);
        test1.setNextCol(test4);
        test1.setNextRow(test5);
        System.out.println("Testing .setNextCol(): " + test1.getNextCol().getData() + ", expected answer is 0.");
        System.out.println("Testing .setNextRow(): " + test1.getNextRow().getData() + ", expected answer is 100.");
    }
}
