import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    private Scanner scanner;
    private String header;
    static List<String> path = Arrays.asList(System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "\\\\").split("\\\\"));
    static String[] pathnames;

    public Console() {
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
        while (true) {
            getCommand().execute();
            System.out.println();
        }
    }

    private void getHeader() {
        System.out.println(this.header);
        System.out.print("$ ");
    }

    private Executable getCommand() {
        getHeader();
        switch (scanner.nextLine().toLowerCase().trim()) {
            case "ls":
                return new Ls();

            case "pwd":
                return new Pwd();

            case "exit":
                return new Exit();

            case "cd ..":
                return new Cd();

            default:
                return () -> System.out.println("nie ma takiej funkcji");
        }
    }
}