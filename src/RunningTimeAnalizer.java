import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunningTimeAnalizer {

    String iterations = "";

    boolean isFirstOperation = true;
    boolean inIfBlock = false;
    boolean inElseBlock = false;
    int ifBlockCount = 0;
    int elseBlockCount = 0;

    public void analyzeCode(List<String> pseudocode) {
        for (String line : pseudocode) {
            line = line.trim().toLowerCase();

            if (line.startsWith("lea")) {
                addOperation("1");
            } else if (line.startsWith("si")) {
                // Start of an 'if' statement
                inIfBlock = true;
                inElseBlock = false;
                ifBlockCount = 0; // Reset instruction count for if block
                addOperation("1"); // Condition check counts as 1 operation
            } else if (line.startsWith("sino")) {
                // Switch to the 'else' block
                inIfBlock = false;
                inElseBlock = true;
                elseBlockCount = 0; // Reset instruction count for else block
            } else if (line.startsWith("esc")) {
                addOperation("1");
                countBlockInstruction(); // Count this instruction in the relevant block
            } else if (line.startsWith("para")) {
                Pattern pattern = Pattern.compile("para.*=(.*),(.*),(.*)");

                Matcher matcher = pattern.matcher(line);

                if (matcher.find()) {
                    String start = matcher.group(1).trim();
                    String end = matcher.group(2).trim();
                    String step = matcher.group(3).trim();

                    String operation = "2 + sum(start: " + start + " end: " + end + ", step: " + step + ", 2";
                    addOperation(operation);
                }
            } else if (line.startsWith("fpara")) {
                addOperation(")");
            } else if (line.contains("=")) {
                addOperation("1");
                countBlockInstruction(); // Count this instruction in the relevant block
            }

            // End of 'if-else' block
            if (line.equals("fsi")) {
                addOperation(String.valueOf(Math.max(ifBlockCount, elseBlockCount))); // Add larger block count
                inIfBlock = false;
                inElseBlock = false;
            }

            System.out.println(this.getRunningTime());
        }
    }

    // Adds the number of operations to the running time expression
    private void addOperation(String iteration) {
        if (isFirstOperation || ) {
            isFirstOperation = false;
            iterations = iterations.concat(" + ");
        }

        iterations = iterations.concat(iteration);
    }

    // Count the instruction based on whether it's inside an if or else block
    private void countBlockInstruction() {
        if (inIfBlock) {
            ifBlockCount++;
        } else if (inElseBlock) {
            elseBlockCount++;
        }
    }

    public String getRunningTime() {
        return iterations;
    }
}
