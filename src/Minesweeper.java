import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Minesweeper {
    public static void main(final String[] theArgs) {
        int x = 1;
        String input = "";
        String after;
        try {
            FileInputStream fis = new FileInputStream("minesweeper_input.txt");
            Scanner scan = new Scanner(fis);

            while (scan.hasNextLine()) {
                input = scan.nextLine();

                // scan the first line
                if (input.matches("0 0")) {
                    System.out.println();
                } else if (input.matches(".*\\d.*")) {
                    System.out.println("Field #" + x++ + ":");
                } else {
//                    after = input.replace('.', '?');
                    after = input;
                    System.out.println(after);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
