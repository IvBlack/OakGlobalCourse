package com.IVdev.stringPool;

/**
 * Метод intern() помещает строку в особую часть heap - string pool.
 * Объект не создается вновь, а возвращается по ссылке в случае,
 * если равны посимвольно.
 */

public class StringPoolEx1
{
    public static void main( String[] args )
    {
       String s1 = "JavaRush";
       String s2 = "JavaRush";
       String s3 = new String("JavaRush").intern();
       String s4 = new String("JavaRush").intern();


        System.out.println("Строка 1 равна строке 2: "+(s1 == s2)); //true
        System.out.println("Строка 2 равна строке 3: "+(s2 == s3)); //true
        System.out.println("Строка 3 равна строке 4: "+(s3 == s4)); //false
    }
}
