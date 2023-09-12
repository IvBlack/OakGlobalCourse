package com.IVdev.Core1.StaticInJava;
/*
На базовом примере - посчитать количество созданных объектов - рассмотрим
как ведут себя static-переменные.
*/

public class Student {
    String name;
    int course;
    static int count;
    int a;

    public Student(String name2, int course2) {
        count++;
        this.name = name2;
        course = course2;
        System.out.println("Student # "+count+" sozdan.");
    }

    /*
    Статичный метод не работает с нестатичными переменными, т.к. a++ обязывает наличие объекта,
    но, объекта не существует для статичного метода. Чтобы работать с нестатичной переменной -
    создайте объект внутри метода и вызывайте переменную из объекта.
    */
    public static void showCount() {
        Student st2 = new Student("Shan", 5);
        st2.a++;
//        a++;
        System.out.println(st2);
        System.out.println("Vsego sozdano studentov: "+count);
    }

    public void showInfo() {
        System.out.println("Welcome to the Student class!!");
    }

    //нестатичный метод работает с нестатичными переменными, ибо и метод и переменная уже существуют на момент создания объекта
    //нестатичный метод так же работает со статичными переменными, т.к. стат.переменные  - общи для всего класса
    public void abc() {
        a++;
        count++;
    }
}

class StudentTest{
    public static void main(String[] args) {
        //при выводе на экран значение count не будет инкрементироваться
        //instance-переменные класса принадлежат каждому объекту и инициализируются каждый раз заново при его создании
        Student st1 = new Student("Ivan", 2);
        Student st2 = new Student("Petr", 1);
        Student st3 = new Student("Mary", 4);
        Student st4 = new Student("Lo", 4);

        /*
        static-переменная принадлежит всему классу, ее нет в каждом создаваемом объекте,
        для нее выделяется место в памяти, не связанное с объектами
        Соответственно, когда каждый объект ее инкрементирует - значение остается в классе
        */
        System.out.println(Student.count);

        //не запрещено обращаться к переменным и методам класса через объекты, но так не пишут код
        System.out.println(st1.count);
        Student.showCount();

        st2.showCount();

        //нестатичные методы не м.б. вызваны из стат.контекста, он м.б. вызван только из объекта
//        Student.abc();
        st1.abc();
    }
}
