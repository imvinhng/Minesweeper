import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class input_generator {
    public static void main(final String[] theArgs) {
        Scanner input = new Scanner(System.in);
        int rows, cols;
        double minePercent;

        // creating minesweeper_input.txt
        try {
            FileWriter myWriter = new FileWriter("minesweeper_input.txt");


            do {
                System.out.print("Enter the rows: ");
                rows = input.nextInt();

                System.out.print("Enter the columns: ");
                cols = input.nextInt();

                System.out.print("Enter mine percent (0 - 1.0): ");
                minePercent = input.nextDouble();

                // Print this into file
                myWriter.write(rows + " " + cols + "\n");

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        if (Math.random() < minePercent) {
                            myWriter.write('*');
                        } else {
                            myWriter.write('.');
                        }
                    }
                    myWriter.write("\n");
                }
            } while (rows != 0 && cols != 0);

            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
