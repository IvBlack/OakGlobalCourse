package com.IVdev.advanced.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    PrintWriter позволяет гибче форматировать вывод.

    Следует избегать бесконечных циклов или бесконечно тяжелых процессов на месте
    Thread.sleep().  Т.к. accept() является блокирующей операцией, клиенты
    в очереди будут ждать высвобождения сокета.
*/
public class  Server2 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080))
        {
            System.out.println("Server 2 initialized...");
            while (true) {
                try
                        (
                                Socket socket = serverSocket.accept();
                                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                        )
                {
                    System.out.println("Client connected...");
                    String request = reader.readLine(); //read the request

                    String[] interMediate = request.split(" ");

                    for (int i = 0; i< interMediate.length; i++) {
                        String response = String.format("Part of a request is: %s", interMediate[i]);
                        Thread.sleep(2000);
                        System.out.println(response);
                        writer.format("<p>%s<p/>", response);
                        writer.flush(); //clear buffer
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
