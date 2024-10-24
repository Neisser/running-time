import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Analizer {
    private static Map<String, Integer> variableMap = new HashMap<>();


    public static void Pseudocode(List<String> lines) {
        int operations = 0;
        String iterations = "";

        for (String line : lines) {
            if (line.matches("[a-zA-Z]+=.+")) {
                processAssignment(line);

                operations++;
            }
        }
    }

    private static void processAssignment(String line) {
        String[] parts = line.split("=");

        String variable = parts[0].trim();

        String expression = parts[1].trim();

        int value = evaluateExpression(expression);

        variableMap.put(variable, value);

        System.out.println("Assigned " + variable + " = " + value);
    }

    private static int evaluateExpression(String expression) {
        expression = expression.replace("mod", "%");
        for (String var : variableMap.keySet()) {
            expression = expression.replace(var, variableMap.get(var).toString());
        }

        try {
            return (int) eval(expression);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0; // Default case, if something goes wrong
    }

    private static Object eval(String expression) throws Exception {
        // Use Java's built-in JavaScript engine to evaluate mathematical expressions
        javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval(expression);
    }
}
