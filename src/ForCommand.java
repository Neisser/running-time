import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForCommand implements Command {
    @Override
    public void execute(String line, RunningTime analyzer) {
        Pattern pattern = Pattern.compile("para.*=(.*),(.*),(.*)");

        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            String start = matcher.group(1).trim();

            String end = matcher.group(2).trim();

            String step = matcher.group(3).trim();

            String operation = String.format("2 + sum(start: %s, end: %s, step: %s, 2", start, end, step);

            analyzer.addOperation(operation);
        }
    }
}
