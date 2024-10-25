public class AssignmentCommand implements Command {
    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.addOperation("1");
    }
}
