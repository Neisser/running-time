public interface Command {
    void execute(String line, RunningTime runningTime);

    default int getBlockCount() {
        return 0;
    }

    default void setBlockCount(int blockCount) {
        // No-op by default
    }

    default void increaseBlockCount() {
        // No-op by default
    }
}
