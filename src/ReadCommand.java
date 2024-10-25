public class ReadCommand implements Command {
    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.addOperation("1");
    }
}
