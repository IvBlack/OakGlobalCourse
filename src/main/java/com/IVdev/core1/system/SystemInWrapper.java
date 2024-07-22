package com.IVdev.core1.system;

import java.io.*;

/*
    (c) CodeGym
    Static method System.setIn() from the class java.lang.System is used to reassign the standard input stream.
* */
public class SystemInWrapper {
    public static void main(String[] args) throws Throwable
    {
        //Put data into a string
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        //Wrap the string in a ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //Replace in!!
        System.setIn(is);

        //Call two ordinary methods that don't know about our changes
//        readAndPrintLine();
        reassignInputFromFile();
    }

    public static void readAndPrintLine() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true)
        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }

    public static void reassignInputFromFile() throws Throwable
    {
        // existing file
        System.out.println("---Demo Code for System.setIn() Method---");
        InputStream stream = new FileInputStream("src/main/java/com/IVdev/core1/system/data.txt");
        System.setIn(stream);

        // read the first character in the file
        char ch = (char) System.in.read();
        System.out.println("Output: " + ch);
    }
}
