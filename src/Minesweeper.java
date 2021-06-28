import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Minesweeper {
    public static void main(final String[] theArgs) {
        int row = 0;
        int col;
        int x = 1;
        String input;
        int rows = 0;
        int cols = 0;
        char[][] matrix = new char[rows][cols];
        try {
            FileInputStream fis = new FileInputStream("minesweeper_input.txt");
            FileWriter myWriter = new FileWriter("minesweeper_output.txt");
            Scanner scan = new Scanner(fis);

            while (scan.hasNextLine()) {
                input = scan.nextLine();

                // scan the first line
                if (input.matches("0 0")) {

                    myWriter.write("\n");
                } else if (input.matches(".*\\d.*")) {

                    // converting char to int
                    rows = Character.getNumericValue(input.charAt(0));
                    cols = Character.getNumericValue(input.charAt(2));

                    row = 0;

                    matrix = new char[rows][cols]; // testing

                    myWriter.write("Field #" + x++ + ":\n");

                } else {
                    for (col = 0; col < cols; col++) {
                        matrix[row][col] = input.charAt(col);
                    }

                    row++;

                    if (row == rows) {
//                        System.out.println("Field #" + x++ + ":");

                        // convert char matrix into int matrix
                        String[][] finalMatrix = checkMines(matrix);

                        // print matrix into output file

                        myWriter.write(printStringMatrix(finalMatrix));


                    }

                }
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
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
        int cols = theMatrix[1].length;
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
         * Temporary method to print char 2d array.
         * @param theMatrix the input
         */
        public static void printCharMatrix (char[][] theMatrix){
            for (char[] matrix : theMatrix) {
                for (int j = 0; j < theMatrix[1].length; j++) {
                    System.out.print(matrix[j]);
                }
                System.out.println();
            }
        }

        /**
         * Temporary method to print string 2d array
         * @param theMatrix the input
         */
        public static String printStringMatrix (String[][]theMatrix){
            StringBuilder sb = new StringBuilder();

            for (String[] matrix : theMatrix) {
                for (int j = 0; j < theMatrix[1].length; j++) {
                    sb.append(matrix[j]);
                }
                sb.append("\n");
            }
            sb.append("\n");

            return sb.toString();
        }
}


