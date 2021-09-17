package core;

import java.util.List;

public class Data {
    private static String header;
    private static String path;
    private static List<String> filesInFolder;
    private static String input;


    public static void getHeader() {
        System.out.print(header + " " + path + "\n$ ");
    }

    public static String getPath() {
        return path;
    }

    public static List<String> getFilesInFolder() {
        return filesInFolder;
    }

    public static String getInput() {
        return input;
    }

    public static void setHeader(String settedHead) {
        header = settedHead;
    }

    public static void setPath(String settedPath) {
        path = settedPath;
    }

    public static void setFilesInFolder(List<String> filesInFolder) {
        Data.filesInFolder = filesInFolder;
    }

    public static void setInput(String input) {
        Data.input = input;
    }
}