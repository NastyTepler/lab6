package app;

public class MyClass {

    // 2 публичных метода
    public void publicMethod1() {
        System.out.println("Вызван publicMethod1");
    }

    public void publicMethod2() {
        System.out.println("Вызван publicMethod2");
    }

    // 2 защищенных метода (protected)
    @Repeat(times = 2)
    protected void protectedMethod1() {
        System.out.println("Вызван protectedMethod1 (2 раза)");
    }

    @Repeat(times = 3)
    protected void protectedMethod2(String text) {
        System.out.println("Вызван protectedMethod2 с аргументом: " + text);
    }

    // 2 приватных метода (private) с параметрами
    @Repeat(times = 2)
    private void privateMethod1(int number) {
        System.out.println("Вызван privateMethod1 с числом: " + number);
    }

    @Repeat(times = 3)
    private void privateMethod2(String name) {
        System.out.println("Вызван privateMethod2 с именем: " + name);
    }
}