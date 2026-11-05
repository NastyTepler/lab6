package app;

import java.lang.reflect.Method;

public class Invoker {
    public static void invokeAnnotatedMethods(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Repeat.class)) {
                Repeat repeat = method.getAnnotation(Repeat.class);
                int times = repeat.times();

                method.setAccessible(true);

                Object[] args = new Object[method.getParameterCount()];
                Class<?>[] paramTypes = method.getParameterTypes();

                for (int i = 0; i < paramTypes.length; i++) {
                    if (paramTypes[i] == int.class) {
                        args[i] = 42; // любое число
                    } else if (paramTypes[i] == String.class) {
                        args[i] = "Тест"; // любая строка
                    }
                }

                System.out.println("--- Вызов метода: " + method.getName() + " ---");
                for (int i = 0; i < times; i++) {
                    method.invoke(obj, args);
                }
            }
        }
    }
}