import java.util.Scanner;

/**
 * Individual solution for Group Assignment 1.
 * @author vnguye3
 */
public class Minesweeper {
    private static Scanner scan;
    private static char[][] matrix;

    public static void main(final String[] theArgs) {

        scan = new Scanner(System.in);

        start();
    }

    /**
     * This method generates output through System.out.
     *
     * User can redirect the output to a text file if needed
     * using cmd prompt
     * @theScanner text file Scanner
     */
    public static void start() {
        int cols = 0;
        int rows = 0;
        int row = 0;
        int x = 1;

        while (scan.hasNextLine()) {
            String input = scan.nextLine();

            // scan the first line
            if (input.matches("0 0")) {

                System.out.println();

            } else if (input.matches(".*\\d.*")) {

                // converting char to int
                String delims = "[ ]+";
                String[] tokens = input.split(delims);

                rows = Integer.parseInt(tokens[0]);
                cols = Integer.parseInt(tokens[1]);

                row = 0;

                matrix = new char[rows][cols]; // testing

                System.out.println("Field #" + x++ + ":");

            } else {
                for (int col = 0; col < cols; col++) {
                    matrix[row][col] = input.charAt(col);
                }

                row++;

                if (row == rows) {

                    // convert char matrix into int matrix
                    String[][] finalMatrix = checkMines(matrix);

                    // print matrix into output file
                    System.out.print(printStringMatrix(finalMatrix));
                    System.out.println("I was here");
                }
            }
        }
    }


    /**
     * Convert char 2d array into String 2d array.
     *
     * @param theMatrix char 2D from input
     * @return finalMatrix String 2D Array with all the mines
     */
    public static String[][] checkMines(final char[][] theMatrix) {
        int rows = theMatrix.length;
        int cols = theMatrix[0].length;
        int mineCount, backRow, frontRow, backCol, frontCol;

        String[][] finalMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (theMatrix[row][col] == '*') {
                    finalMatrix[row][col] = "*";
                } else {
                    mineCount = 0;
                    backRow = row - 1;
                    frontRow = row + 1;
                    backCol = col - 1;
                    frontCol = col + 1;

                    // check same row
                    if (backCol >= 0 && theMatrix[row][backCol] == '*') {
                        mineCount++;
                    }
                    if (frontCol < cols && theMatrix[row][frontCol] == '*') {
                        mineCount++;
                    }

                    // check same col
                    if (backRow >= 0 && theMatrix[backRow][col] == '*') {
                        mineCount++;
                    }
                    if (frontRow < rows && theMatrix[frontRow][col] == '*') {
                        mineCount++;
                    }

                    // check diagonals
                    if (backRow >= 0 && backCol >= 0 && theMatrix[backRow][backCol] == '*') {
                        mineCount++;
                    }
                    if (backRow >= 0 && frontCol < cols && theMatrix[backRow][frontCol] == '*') {
                        mineCount++;
                    }
                    if (frontRow < rows && backCol >= 0 && theMatrix[frontRow][backCol] == '*') {
                        mineCount++;
                    }
                    if (frontRow < rows && frontCol < cols && theMatrix[frontRow][frontCol] == '*') {
                        mineCount++;
                    }
                    finalMatrix[row][col] = String.valueOf(mineCount);
                }
            }
        }

        return finalMatrix;
    }


        /**
         * Temporary method to print string 2d array
         * @param theMatrix the input
         */
        public static String printStringMatrix (String[][]theMatrix){
            StringBuilder sb = new StringBuilder();

            for (String[] matrix : theMatrix) {
                for (int j = 0; j < theMatrix[0].length; j++) {
                    sb.append(matrix[j]);
                }
                sb.append("\n");
            }
            sb.append("\n");

            return sb.toString();
        }

}


