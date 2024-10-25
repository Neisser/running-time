public class EndForCommand implements Command {
    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.addIteration(")");
    }
}
