import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RunningTimeUI::new);
    }

    public static void performAnalysis(String pseudocodeFile, RunningTimeUI ui) {
        try {
            List<String> lines = Reader.File(pseudocodeFile);

            Commands commands = new Commands();

            RunningTime analyzer = new RunningTime();

            analyzer.setCommandMap(commands.getCommandMap());

            analyzeCode(lines, analyzer);

            // Display the result in UI
            ui.displayRunningTime(analyzer.getRunningTime());
        } catch (IOException e) {
            ui.displayRunningTime("Error: " + e.getMessage());
        }
    }

    public static void analyzeCode(List<String> code, RunningTime analyzer) {
        for (String line : code) {
            line = line.trim().toLowerCase();

            String keyword = Utils.extractKeyword(line);

            boolean isStart = keyword.equals(CommandType.START.toString());

            boolean isStop = keyword.equals(CommandType.STOP.toString());

            if(!isStart && !isStop) {

                // Find the command by keyword and execute it, fallback to default if not found
                Command command = analyzer.commandMap
                        .getOrDefault(CommandType.fromString(keyword), new AssignmentCommand());

                command.execute(line, analyzer);

                analyzer.setIsFirstOperation();
            }
        }
    }
}