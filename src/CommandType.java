public enum CommandType {
    START("inicio"),
    STOP("pare"),
    READ("lea"),
    WRITE("esc"),
    IF("si"),
    ELSE("sino"),
    ENDIF("fsi"),
    FOR("para"),
    ENDFOR("fpara"),
    ASSIGNMENT("=");

    private final String command;

    CommandType(final String command){
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return command;
    }

    // Find the enum by its command string
    public static CommandType fromString(String text) {
        for (CommandType type : CommandType.values()) {
            if (type.getCommand().equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null; // Handle unknown commands appropriately
    }
}
