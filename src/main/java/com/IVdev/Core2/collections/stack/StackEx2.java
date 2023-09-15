package com.IVdev.Core2.collections.stack;

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

        //метод pop извлекает элемент из вершины стэка и удаляет его
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
