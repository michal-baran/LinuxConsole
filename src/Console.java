import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    private static String computerName;
    private static String[] pathnames;
    private static File file = new File(System.getProperty("user.dir"));

    static {
        try {
            computerName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static String header = System.getProperty("user.name") + "@" + computerName;

    public static void init() {
        while (true) {
            getHeader();
            getCommand().execute();
            System.out.println();
        }
    }

    private static void getHeader() {
        System.out.println(header);
    }

    private static Executable getCommand() {
        System.out.print("$ ");
        switch (scanner.nextLine().toLowerCase().trim()) {
            case "ls":
                pathnames = file.list();
                for (String s : pathnames)
                    return new Ls();

            case "pwd":
                return new Pwd();

            case "exit":
                return new Exit();

            case "cd":
                return new Cd();

            default:
                return () -> System.out.println("nie ma takiej funkcji");
        }
    }
}
