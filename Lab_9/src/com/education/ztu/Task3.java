package com.education.ztu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Task3 {
    public static void DoTask() {
        Class<MyClass> myClass1 = MyClass.class;
        Class<?> myClass2 = new MyClass().getClass();
        try {
            Class<?> myClass3 = Class.forName("com.education.ztu.MyClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] fields = MyClass.class.getDeclaredFields();
        Method[] methods = MyClass.class.getDeclaredMethods();
        Constructor<?>[] constructors = MyClass.class.getDeclaredConstructors();

        System.out.println("Поля:");
        for (Field field : fields) {
            System.out.println("Назва: " + field.getName() + ", Тип: " + field.getType());
        }

        System.out.println("\nМетоди:");
        for (Method method : methods) {
            System.out.println("Назва: " + method.getName() + ", Параметри: " + Arrays.toString(method.getParameterTypes()) + ", Повертає: " + method.getReturnType());
        }

        System.out.println("\nКонструктори:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("Назва: " + constructor.getName() + ", Параметри: " + Arrays.toString(constructor.getParameterTypes()));
        }

        MyClass userInstance = null;
        try {
            userInstance = MyClass.class.getDeclaredConstructor(int.class, String.class).newInstance(42, "privateFieldValue");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (userInstance != null) {
            try {
                Method publicMethod = MyClass.class.getDeclaredMethod("publicMethod");
                publicMethod.invoke(userInstance);

                // Робота з приватним полем
                Field privateField = MyClass.class.getDeclaredField("privateField");
                privateField.setAccessible(true);
                System.out.println("Початкове значення приватного поля: " + privateField.get(userInstance));
                privateField.set(userInstance, "Нове значення приватного поля");
                System.out.println("Нове значення приватного поля: " + privateField.get(userInstance));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
