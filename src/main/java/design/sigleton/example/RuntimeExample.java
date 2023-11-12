package design.sigleton.example;

public class RuntimeExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
    }
}
