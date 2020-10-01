package processor;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[][] matrixA;
        double[][] matrixB;
        double[][] matrixC;
        boolean inMenu = true;

        while (inMenu) {
            int choice = menu(scan);
            switch (choice) {
                case 1:
                    matrixA = scanInput(scan);
                    matrixB = scanInput(scan);
                    matrixC = addMatrix(matrixA, matrixB);
                    if (matrixC == null) {
                        System.out.println("ERROR");
                    } else {
                        printMatrix(matrixC);
                    }
                    break;
                case 2:
                    matrixA = scanInput(scan);
                    System.out.println("Enter constant:");
                    int multiple = scan.nextInt();
                    matrixB = multiplyByScalar(multiple, matrixA);
                    printMatrix(matrixB);
                    break;
                case 3:
                    matrixA = scanInput(scan);
                    matrixB = scanInput(scan);
                    matrixC = dotProduct(matrixA, matrixB);
                    if (matrixC == null) {
                        System.out.println("ERROR");
                    } else {
                        printMatrix(matrixC);
                    }
                    break;
                case 0:
                    inMenu = false;

            }
        }
    }

    static double[][] dotProduct(double[][] matA, double[][] matB) {

        if(matA[0].length != matB.length) {
            System.out.println("A: " + matA[0].length);
            System.out.println("B: " + matB.length);
            return null;
        }

        double[][] matC = new double[matA.length][matB.length];

        for (int ii = 0; ii < matA.length; ii++) {
            for (int jj = 0; jj < matB.length; jj++) {
                double sum = 0;
                for (int kk = 0; kk < matB.length; kk++) {

                    sum += matA[ii][kk]
                            * matB[kk][jj];

                }
                matC[ii][jj] = sum;
            }
        }
        return matC;
    }

    static int menu(Scanner scan) {
        System.out.println("1- Add Matrices");
        System.out.println("2- Multiply by Constant");
        System.out.println("3- Multiply Matrices");
        System.out.println("0- Exit");
        return scan.nextInt();
    }

    static double[][] multiplyByScalar(int scalar, double[][] matrix) {

        double[][] matrixOut = new double[matrix.length][matrix[0].length];

        for (int ii = 0; ii < matrix.length; ii++) {
            for (int jj = 0; jj < matrix[0].length; jj++) {
                matrixOut[ii][jj] = matrix[ii][jj] * scalar;
            }
        }
        return matrixOut;
    }

    static void printMatrix(double[][] matrix) {
        System.out.println("The result is:");
        for (int ii = 0; ii < matrix.length; ii++) {
            for (int jj = 0; jj < matrix[0].length; jj++) {
                System.out.print(matrix[ii][jj] + " ");
            }
            System.out.print('\n');
        }
    }

    static double[][] scanInput(Scanner scan) {
        System.out.println("Enter matrix size:");
        double rows = scan.nextDouble();
        double columns = scan.nextDouble();
        double[][] matrix = new double[(int) rows][(int) columns];
        System.out.println("Enter matrix:");
        for (int ii = 0; ii < rows; ii++) {
            for (int jj = 0; jj < columns; jj++) {
                matrix[ii][jj] = scan.nextDouble();
            }
        }
        return matrix;
    }

    static double[][] addMatrix(double[][] matA, double[][] matB) {
        if(!(matA.length == matB.length || matA[0].length == matB[0].length)) {
            return null;
        }
        double[][] matC = new double[matA.length][matA[0].length];
        for (int ii = 0; ii < matA.length; ii++) {
            for (int jj = 0; jj < matA[0].length; jj++) {
                matC[ii][jj] = matA[ii][jj] + matB[ii][jj];
            }
        }
        return matC;
    }
}
