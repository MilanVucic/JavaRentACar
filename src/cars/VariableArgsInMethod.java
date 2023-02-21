package cars;

public class VariableArgsInMethod {
    public static void main(String[] args) {
        something(1);
        something(2,"Milan");
        something(3, "Milan", "Marco");
        something(5,"Milan", "Marco", "Elena");
    }

    public static void something(int a, String... args) {
        System.out.println(args.length);
    }
}
