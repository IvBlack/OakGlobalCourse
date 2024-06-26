package com.IVdev.core1.VariableScopes;

public class Car {
    /*
    Instance-переменные color, engine: область видимости - принадлежит объекту.
    Переменная count является статической, область видимости - весь класс
    */
    String color;
    String engine;
    static int count;
    int a = 10;

    /*****************************
    Имена идентификаторов могут начинаться с:
    - прописных и заглавных букв
    - символов валюты (любой валюты), причем в любом месте
    - с нижнего подчеркивания (underscore)
    - иметь имена ссылочных типов данных (String, Integer и пр.)
     - имена констант - всегда заглавные

    Не могут:
    - с цифры
    - иметь имена зарезервированных слов
    */
    String _$4Asfdf$dt = "8";
    //int true = 7;
    int String = 645645;
    final int XYZ = 3;


    //можно обратиться к статической переменной через вызов this объекта, но не рекомендуется
    public Car(String color2, String engine2) {
        this.count++;
        color = color2;
        engine = engine2;
    }

    //this.a = b: ошибка компиляции, т.к. объекта еще может не существовать, когда отработает changeA
    //объект Car существует только в области видимости метода changeA
    public static void changeA(int b, Car car) {
        //this.a = b;
        car.a = 7;
    }

    public void showColor() {
        System.out.println("Car's color is " + color);
//        int a = price;
    }

    /*
    Локальная переменная price создана внутри метода: область видимости - от момента создания до }
    нельзя объявить price вне метода - это будет другая переменная.
    Локальные переменные не имеют модификаторов доступа.

    Параметр color3 - область видимости - весь метод, немного больше области лое.переменной.
    */
    public void changeColor(String color3) {
        //int a = price;
        System.out.println("Color has been changed!");
        int price = 5000;
        color = color3;
        price += 1000;
    }
}
