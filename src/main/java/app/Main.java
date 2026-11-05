package app;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(" Задание 1: Рефлексия и аннотации ");
            MyClass obj = new MyClass();
            Invoker.invokeAnnotatedMethods(obj);

            FileSystemTask.run();

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}