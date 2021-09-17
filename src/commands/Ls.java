package commands;
import core.Data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ls implements Command {
    private static final StringBuilder result = new StringBuilder();

    @Override
    public void execute() {
        Data.setFilesInFolder(listFiles(new File(Data.getPath())));
    }

    private List<String> listFiles(final File folder) {
        List<String> filesInFolder = new ArrayList<>();
        for (File fileEntry : folder.listFiles()) {
            filesInFolder.add(fileEntry.getName());
            System.out.println(fileEntry.getName());
        }
        return filesInFolder;
    }
}