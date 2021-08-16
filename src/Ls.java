import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ls implements Executable {
    private static StringBuilder result = new StringBuilder();

    @Override
    public void execute(Console console) {
        console.setFilesInFolder(listFiles(new File(console.getPath())));
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