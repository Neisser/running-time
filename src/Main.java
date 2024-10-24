import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String pseudocodeFile = "./assets/script1.txt";

        try {
            List<String> lines = Reader.File(pseudocodeFile);

//            Queue code = new Queue();
//
//            for (String line : lines) {
//                code.enqueue(line);
//            }

            RunningTimeAnalizer analyzer = new RunningTimeAnalizer();

            analyzer.analyzeCode(lines);

            System.out.println("Running Time Expression: " + analyzer.getRunningTime());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}