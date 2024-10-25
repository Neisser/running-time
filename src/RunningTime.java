import java.util.HashMap;
import java.util.Map;

public class RunningTime {
    public BlockType currentBlock = BlockType.NONE;

    private String iterations = "";

    private boolean isFirstOperation = true;

    public final Map<CommandType, Command> commandMap = new HashMap<>();

    public String getRunningTime() {
        return iterations;
    }

    public void setIsFirstOperation() {
        isFirstOperation = false;
    }

    public void setCommandMap(Map<CommandType, Command> map) {
        commandMap.putAll(map);
    }

    public void addOperation(String operation) {

        if (currentBlock == BlockType.IF) commandMap.get(CommandType.IF).increaseBlockCount();

        if (currentBlock == BlockType.ELSE) commandMap.get(CommandType.ELSE).increaseBlockCount();

        if(currentBlock != BlockType.IF && currentBlock != BlockType.ELSE) {

            if (!isFirstOperation) {
                iterations += " + ";
            }

            iterations += operation;
        }
    }

    public void addIteration(String iteration) {
        iterations += iteration;
    }
}
