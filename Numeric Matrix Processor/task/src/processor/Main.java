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
            int choiceA = menu(scan);
            switch (choiceA) {
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
                case 4:
                    int choiceB = transposeMenu(scan);
                    matrixA = scanInput(scan);
                    switch (choiceB) {
                        case 1:
                            matrixB = transpose(matrixA);
                            printMatrix(matrixB);
                            break;
                        case 2:
                            matrixB = flipVertical(matrixA);
                            matrixC = transpose(matrixB);
                            matrixA = flipVertical(matrixC);
                            printMatrix(matrixA);
                            break;
                        case 4:
                            matrixB = flipVertical(matrixA);
                            printMatrix(matrixB);
                            break;
                        case 3:
                            matrixB = flipHorizontal(matrixA);
                            printMatrix(matrixB);
                            break;

                    }
                case 0:
                    inMenu = false;

            }
        }
    }

    private static double[][] flipVertical(double[][] matA) {
        double[][] matB = new double[matA.length][matA[0].length];
        for (int ii = 0; ii < matA.length; ii++) {
            for (int jj = 0; jj < matA[0].length; jj++) {
                matB[matA.length - ii - 1][jj] = matA[ii][jj];
            }
        }
        return matB;
    }

    private static double[][] flipHorizontal(double[][] matA) {
        double[][] matB = new double[matA.length][matA[0].length];
        for (int ii = 0; ii < matA.length; ii++) {
            for (int jj = 0; jj < matA[0].length; jj++) {
                matB[ii][matA[0].length - jj - 1] = matA[ii][jj];
            }

        }
        return matB;
    }

    private static double[][] transpose(double[][] matA) {
        double[][] matB = new double[matA[0].length][matA.length];

        for (int ii = 0; ii < matA.length; ii++) {
            for (int jj = 0; jj < matA[0].length; jj++) {
                matB[jj][ii] = matA[ii][jj];
            }
        }
        return matB;
    }

    static int transposeMenu(Scanner scan) {
        System.out.println("Normal Transpose");
        System.out.println("Secondary Diagonal Transpose");
        System.out.println("Horizontal Transpose");
        System.out.println("Vertical Transpose");
        return scan.nextInt();
    }

    static double[][] dotProduct(double[][] matA, double[][] matB) {

        if(matA[0].length != matB.length) {
            System.out.println("A: " + matA[0].length);
            System.out.println("B: " + matB.length);
            return null;
        }

        double[][] matC = new double[matA.length][matB[0].length];
        for (int nn = 0; nn < matA.length; nn++) {
            for (int kk = 0; kk < matB[0].length; kk++) {
                double sum = 0;
                for (int mm = 0; mm < matB.length; mm++) {
                    sum += matA[nn][mm] * matB[mm][kk];
                }
                matC[nn][kk] = sum;
            }
        }
        return matC;
    }



    static int menu(Scanner scan) {
        System.out.println("1- Add Matrices");
        System.out.println("2- Multiply by Constant");
        System.out.println("3- Multiply Matrices");
        System.out.println("4- Transpose");
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
