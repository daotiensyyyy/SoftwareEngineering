package utils;

public class Utils {
    static final String host = "http://localhost:8080/";

    public static String fullPath(String path) {
        return host + path;
    }
}
