package commands;

import core.Data;

import java.io.File;

public class Cd implements Command {
    String command;

    @Override
    public void execute() {
        System.out.println("This is command CD");
        //        String path = Data.getPath();
//        if (this.command.equals("..")) {
//            try {
//                Data.setPath(path.substring(0, path.lastIndexOf('\\')));
//            } catch (StringIndexOutOfBoundsException e) {
//
//            }
//        } else if (Data.getFilesInFolder().contains(command) & new File(path + "\\" + command).isDirectory()) {
//            Data.setPath(path + "\\" + command);
//        } else {
//            System.out.println("No such file or directory");
//        }
    }
}
