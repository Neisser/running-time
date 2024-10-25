public class Utils {
    public static String extractKeyword(String line) {
        String[] parts = line.split("\\s+");

        return parts.length > 0 ? parts[0] : "";
    }
}
