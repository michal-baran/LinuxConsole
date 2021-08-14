public class Ls implements Executable {
    private static StringBuilder result = new StringBuilder();

    @Override
    public void execute() {
        for (String s : Console.path) {
            result.append(s).append("\\");
        }
        System.out.println(result);
    }
}
