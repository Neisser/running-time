import java.util.HashMap;
import java.util.Map;

public class Commands {

    public final Map<CommandType, Command> commandMap = new HashMap<>();

    private void registerCommands() {
        commandMap.put(CommandType.READ, new ReadCommand());
        commandMap.put(CommandType.WRITE, new WriteCommand());
        commandMap.put(CommandType.IF, new IfCommand());
        commandMap.put(CommandType.ELSE, new ElseCommand());
        commandMap.put(CommandType.ENDIF, new EndIfCommand());
        commandMap.put(CommandType.FOR, new ForCommand());
        commandMap.put(CommandType.ENDFOR, new EndForCommand());
        commandMap.put(CommandType.ASSIGNMENT, new AssignmentCommand());
    }

    public Commands() {
        registerCommands();
    }

    public Map<CommandType, Command> getCommandMap() {
        return commandMap;
    }

}
