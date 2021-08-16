public class Pwd implements Executable {

    @Override
    public void execute(Console console) {
        System.out.println(console.getPath());
    }
}