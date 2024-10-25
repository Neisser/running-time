public class ElseCommand implements Command {
    private int blockCount = 0;

    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.currentBlock = BlockType.ELSE;

        setBlockCount(0);
    }

    @Override
    public int getBlockCount() {
        return blockCount;
    }

    @Override
    public void setBlockCount(int blockCount) {
        this.blockCount = blockCount;
    }

    @Override
    public void increaseBlockCount() {
        blockCount++;
    }
}
