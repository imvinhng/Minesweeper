import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUNIT test cases for Minesweeper.java.
 * There are 26 test cases for 26 mine fields in minesweeper_input.txt
 *
 * Make sure to redirect minesweeper_output.txt to MinesweeperTest in cmd
 * to check the correct output
 *
 * Please ignore this test case since this is not our official JUNIT Test solution
 * @author vnguye3
 * @version 1.0
 */
class MinesweeperTest {
    Scanner scan = new Scanner(new File("minesweeper_output.txt"));

    MinesweeperTest() throws FileNotFoundException {
    }


    @Test
    void test1By1AllMines() {
        assertEquals(scan.nextLine(), "Field #1:");
        assertEquals(scan.nextLine(), "*");
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test1By1NoMines() {
        for (int i = 0; i < 3; i++) {
            scan.nextLine();
        }
        assertEquals(scan.nextLine(), "Field #2:");
        assertEquals(scan.nextLine(), "0");
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test100By1AllMines() {
        for (int i = 0; i < 6; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #3:");

        for (int i = 0; i < 100; i++) {
            assertEquals(scan.nextLine(), "*");
        }
    }

    @Test
    void test100By1SomeMines() {
        for (int i = 0; i < 108; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #4:");
        // to be continued
    }

    @Test
    void test100By1NoMines() {
        for (int i = 0; i < 210; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #5:");
        for (int i = 0; i < 100; i++) {
            assertEquals(scan.nextLine(), "0");
        }
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test1By100AllMines() {
        for (int i = 0; i < 312; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #6:");
        assertEquals(scan.nextLine(), "********************************************" +
                "********************************************************");
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test1By100SomeMines() {
        for (int i = 0; i < 315; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #7:");
        assertEquals(scan.nextLine(), "1***11*11*10001*101*****1001*101*******2****" +
                "10001**11*2*11*101*1001*10001*11*101*2*11*11**********10");
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test1By100NoMines(){
        for (int i = 0; i < 318; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #8:");
        assertEquals(scan.nextLine(), "00000000000000000000000000000000000000000000" +
                "00000000000000000000000000000000000000000000000000000000");
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test100By100AllMines(){
        for (int i = 0; i < 321; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #9:");
        for (int i = 0; i < 100; i++) {
            assertEquals(scan.nextLine(), "********************************************" +
                    "********************************************************");
        }
        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test100By100SomeMines(){
        for (int i = 0; i < 423; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #10:");

        // to be continued

//        assertEquals(scan.nextLine(), "");
    }

    @Test
    void test100By100NoMines(){
        for (int i = 0; i < 525; i++) {
            scan.nextLine();
        }

        assertEquals(scan.nextLine(), "Field #11:");
        for (int i = 0; i < 100; i++) {
            assertEquals(scan.nextLine(), "00000000000000000000000000000000000000000000" +
                    "00000000000000000000000000000000000000000000000000000000");
        }
        assertEquals(scan.nextLine(), "");
    }

    // field #12
    @Test
    void test50By50SomeMines(){}

    // field #13
    @Test
    void test50By50SomeMines2(){}

    // field #14
    @Test
    void test50By50SomeMines3(){}

    // field #15
    @Test
    void test50By50SomeMines4(){}

    // field #16
    @Test
    void test50By50SomeMines5(){}

    // field #17
    @Test
    void test30By30SomeMines(){}

    // field #18
    @Test
    void test30By30SomeMines2(){}

    // field #19
    @Test
    void test30By30SomeMines3(){}

    // field #20
    @Test
    void test30By30SomeMines4(){}

    // field #21
    @Test
    void test30By30SomeMines5(){}

    // field #22
    @Test
    void test20By20SomeMines(){}

    // field #23
    @Test
    void test20By20SomeMines2(){}

    // field #24
    @Test
    void test20By20SomeMines3(){}

    // field #25
    @Test
    void test20By20SomeMines4(){}

    // field #26
    @Test
    void test20By20SomeMines5(){}








}