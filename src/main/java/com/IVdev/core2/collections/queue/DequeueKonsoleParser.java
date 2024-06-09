package com.IVdev.core2.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    It should print content for each pair of tags.

    There are two rules for printing order:
    the same hierarchy level tags are processed left to right;
    if a tag has other tags as children, -
    children should be processed first. If there are no children or
    all of them were processed already, the tag can be processed.
* */
public class DequeueKonsoleParser {
    public static void main(String[] args) {
        // put your code here
        String input = new Scanner(System.in).nextLine();
        Matcher m = Pattern.compile("<.+?>").matcher(input); //regex syntax check

        Deque<String> stack = new ArrayDeque<>();
        while (m.find()) {
            if (m.group().contains("/")) {
                System.out.println(stack.pop()); //returns with removal from the beginning of queue
            } else {
                Matcher p = Pattern.compile("<(\\w+)>(.*?)</\\1>").matcher(input);
                p.find(m.start());
                stack.push(p.group(2)); //adds element to beginning of queue
            }
        }
    }
}
