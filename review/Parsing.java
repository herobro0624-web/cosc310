package review;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parsing {
    public static void main(String[] args) {
        File f = new File("review/palindromes.csv");
        try (Scanner in = new Scanner(f)) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }
}
