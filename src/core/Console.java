package core;

import commands.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    private final Scanner scanner;
    Map<String, Command> commandMap = Map.of(
            "cd", new Cd(),
            "exit", new Exit(),
            "ls", new Ls(),
            "pwd", new Pwd()
    );

    public Console() {
        this.scanner = new Scanner(System.in);
        Data.setPath(System.getProperty("user.dir").replaceAll(Pattern.quote("\\"), "\\\\"));
        try {
            Data.setHeader(System.getProperty("user.name") + "@" + InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static Console create() {
        return new Console();
    }

    public void init() {
        while (true)
            executeCommand();
    }

    private void executeCommand() {
        Data.getHeader();
        Data.setInput(scanner.nextLine());
        commandMap.get(Data.getInput().toLowerCase().trim().split(" ")[0]).execute();
    }
}