public class SparseIntMatrixTest {

    // Just a quick note. I've put tests for the methods, but they don't show unless you comment out the MatrixViewer commands for the matrix data files below. -Ibrahim

    public static void main(String[] args) {
        // Testing first constructor and basic methods: .setElement(); , .getElement(); , .removeElement(); , .getNumCols(); , .getNumRows(); , .plus(SparseIntMatrix otherMat); , .minus(SparseIntMatrix otherMat);
        SparseIntMatrix testSparse = new SparseIntMatrix(2,2);

        // Test for .getNumCols(); & .getNumRows();
        System.out.println("Test for .getNumCols(); & .getNumRows();");
        System.out.println(testSparse.getNumCols() + ", should return 2");
        System.out.println(testSparse.getNumRows() + ", should return 2");

        System.out.println("-----------");

        // Test for .setElement(); & .getElement();
        System.out.println(".setElement(); & .getElement();");
        testSparse.setElement(0,0,1);
        testSparse.setElement(1,0,3);
        testSparse.setElement(0,1,2);
        testSparse.setElement(1,1,4);
        System.out.print(testSparse.getElement(0,0) + " ");
        System.out.println(testSparse.getElement(0,1));
        System.out.print(testSparse.getElement(1,0) + " ");
        System.out.println(testSparse.getElement(1,1));
        System.out.println("Above should show \n1 2 \n3 4");

        System.out.println("-----------");

        // Test for .plus();
        System.out.println("Test for .plus();");
        testSparse.plus(testSparse);
        System.out.print(testSparse.getElement(0,0) + " ");
        System.out.println(testSparse.getElement(0,1));
        System.out.print(testSparse.getElement(1,0) + " ");
        System.out.println(testSparse.getElement(1,1));
        System.out.println("Above should show \n2 4 \n6 8");

        System.out.println("-----------");

        // Test for .minus();
        System.out.println("Test for .minus();");
        testSparse.minus(testSparse);
        System.out.print(testSparse.getElement(0,0) + " ");
        System.out.println(testSparse.getElement(0,1));
        System.out.print(testSparse.getElement(1,0) + " ");
        System.out.println(testSparse.getElement(1,1));
        System.out.println("Above should show \n0 0 \n0 0");

        System.out.println("-----------");

        // testSparse reset to [[1,2],[3,4]] format
        System.out.println("Just a quick reset so we can test .removeElement();");
        testSparse.setElement(0,0,1);
        testSparse.setElement(1,0,3);
        testSparse.setElement(0,1,2);
        testSparse.setElement(1,1,4);
        System.out.print(testSparse.getElement(0,0) + " ");
        System.out.println(testSparse.getElement(0,1));
        System.out.print(testSparse.getElement(1,0) + " ");
        System.out.println(testSparse.getElement(1,1));
        System.out.println("Above should show \n1 2 \n3 4");

        System.out.println("-----------");

        // Test for .removeElement();
        System.out.println("Test for .removeElement();");
        testSparse.removeElement(0,0,1);
        testSparse.removeElement(1,0,3);
        testSparse.removeElement(0,1,2);
        testSparse.removeElement(1,1,4);
        System.out.print(testSparse.getElement(0,0) + " ");
        System.out.println(testSparse.getElement(0,1));
        System.out.print(testSparse.getElement(1,0) + " ");
        System.out.println(testSparse.getElement(1,1));
        System.out.println("Above should show \n0 0 \n0 0");

        SparseIntMatrix mat = new SparseIntMatrix(1000,1000,"matrix1_data.txt");
        SparseIntMatrix mat2 = new SparseIntMatrix(1000,1000,"matrix2_data.txt");
        SparseIntMatrix matNoise = new SparseIntMatrix(1000,1000,"matrix2_noise.txt");
        MatrixViewer.show(mat2);
        mat2.minus(matNoise);
        MatrixViewer.show(mat);
        MatrixViewer.show(mat2);

    }
}
