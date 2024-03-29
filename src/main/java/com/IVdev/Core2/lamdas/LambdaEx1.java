package com.IVdev.Core2.lamdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/*
Суть сниппета: показать, как сокращает код использование лямбда-выражений,
которые представляют собой сокращенную запись метода функционального интерфейса.
А так же преимущество над анонимными классами(способ 2).
У лямбды всегда есть параметр (или несколько) и действие, кот.вы хотите с ними произвести.
*/
public class LambdaEx1 {
    public static void main(String[] args) {
        File src = new File(".");
//        File[] files = src.listFiles(((p) -> p.isDirectory()); //лямбда-выражение
        File[] files = src.listFiles((File::isDirectory)); //лямбда заменена референс-методом.

        System.out.println("this is NOT directories: ");
        for(File file : files) {
                System.out.println(file.getName());
        }
    }
}

//1й и громоздкий способ: внедрить объект фильтра в параметры метода src.listFiles()
class MyFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return !pathname.isDirectory();
    }
}

//2й способ вызвать метод прямо в теле анонимного класса:
    //public static void main(String[] args) {
    //    File src = new File(".");
    //    File[] files = src.listFiles(new FileFilter() {
    //
    //        @Override
    //        public boolean accept(File pathname) {
    //            return !pathname.isDirectory();
    //        }
    //    });
    //
    //    for(File file : files) {
    //        System.out.println(file.getName());
    //    }
    //}




