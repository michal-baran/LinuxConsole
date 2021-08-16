import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    private final Scanner scanner;
    private String header;
    private String path;
    private List<String> filesInFolder;

    public Console() {
        this.path = System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "\\\\");
        this.scanner = new Scanner(System.in);
        try {
            this.header = System.getProperty("user.name") + "@" + InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static Console create() {
        return new Console();
    }

    public void init() {
        getCommand().execute(this);
        System.out.println();
        this.init();
    }

    public String getPath() {
        return path;
    }

    public List<String> getFilesInFolder() {
        return filesInFolder;
    }

    private void getHeader() {
        System.out.print(this.header + " ~\n$ ");
    }

    private Executable getCommand() {
        getHeader();
        String input = scanner.nextLine();
        switch (input.toLowerCase().trim().split(" ")[0]) {
            case "ls":
                return new Ls();

            case "pwd":
                return new Pwd();

            case "exit":
                return new Exit();

            case "cd":
                return new Cd(input.substring(input.indexOf(" ") + 1));

            default:
                return (param) -> System.out.println(input + ": command not found");
        }
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setFilesInFolder(List<String> filesInFolder) {
        this.filesInFolder = filesInFolder;
    }
}