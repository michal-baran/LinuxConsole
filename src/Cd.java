public class Cd implements Executable {
    String command;

    public Cd(String command) {
        this.command = command;
    }

    @Override
    public void execute(Console console) {
        String path = console.getPath();
        if (this.command.equals("..")) {
            try {
                console.setPath(path.substring(0, path.lastIndexOf('\\')));
            } catch (StringIndexOutOfBoundsException e) {

            }
        } else if (console.getFilesInFolder().contains(command)){
            console.setPath(path + "\\" + command);
        } else {
            System.out.println("No such file or directory");
        }
    }
}
