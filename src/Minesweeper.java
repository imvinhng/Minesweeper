import java.io.*;
import java.util.Scanner;

public class Minesweeper {
    public static void main(final String[] theArgs) {
        int x = 1;
        String input;
        String after;
        try {
            FileInputStream fis = new FileInputStream("minesweeper_input.txt");
            FileWriter myWriter = new FileWriter("minesweeper_output.txt");
            Scanner scan = new Scanner(fis);

            while (scan.hasNextLine()) {
                input = scan.nextLine();

                // scan the first line
                if (input.matches("0 0")) {
//                    System.out.println();
                    myWriter.write("\n");
                } else if (input.matches(".*\\d.*")) {
//                    System.out.println("Field #" + x++ + ":");
                    myWriter.write("Field #" + x++ + ":\n");
                } else {
//                    after = input.replace('.', '?');
                    after = input;
//                    System.out.println(after);
                    myWriter.write(after + "\n");
                }
            }

            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
