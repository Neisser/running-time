public class IfCommand implements Command {
    public int blockCount = 0;

    @Override
    public void execute(String line, RunningTime analyzer) {
        analyzer.addOperation("1");

        analyzer.currentBlock = BlockType.IF;

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
