public class EndIfCommand implements Command {
    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.currentBlock = BlockType.NONE;

        Command ifcommnad = analyzer.commandMap.get(CommandType.IF);

        Command elseCommand = analyzer.commandMap.get(CommandType.ELSE);

        int blockCount = Math.max(ifcommnad.getBlockCount(), elseCommand.getBlockCount());

        if(blockCount > 0) analyzer.addOperation(String.valueOf(blockCount));
    }
}
