package com.IVdev.core2.collections.stack;

import java.util.Stack;

public class StackEx2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //метод push помещает элемент на вершину стека
        stack.push("Ivan");
        stack.push("Son");
        stack.push("Lu");
        stack.push("Yan");
        System.out.println(stack);

//        while(!stack.isEmpty()) {z

//            //метод pop извлекает элемент из вершины стэка и удаляет его
//            System.out.println(stack.pop());
//            System.out.println(stack);
//        }

        //peek используется для извлечения элемента на вершине стека БЕЗ его удаления
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
