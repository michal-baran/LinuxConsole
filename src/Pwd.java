import java.io.File;

public class Pwd implements Executable {
    @Override
    public void execute() {
        System.out.println(System.getProperty("user.dir"));
    }
}
