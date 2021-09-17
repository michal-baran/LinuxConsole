package commands;

import core.Data;

public class Pwd implements Command {

    @Override
    public void execute() {
        System.out.println(Data.getPath());
    }
}