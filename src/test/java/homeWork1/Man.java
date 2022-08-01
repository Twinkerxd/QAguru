package homeWork1;

public class Man {
    String name;
    int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void doNothing() {
        System.out.println("Man is doing nothing...");
    }

    public void run() {
        System.out.println("Man is running...");
    }
}
