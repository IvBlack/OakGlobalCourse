package com.IVdev.advanced.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    java.net.Socket представляет собой сокет, который клиент и сервер используют для связи друг с другом.
    Клиент получает объект сокета, создав его, тогда как сервер получает объект сокета из возвращаемого значения
    метода accept (). Класс Socket имеет пять конструкторов, которые клиент использует для подключения к серверу.

    Клиентом, осуществляющим запросы, м.б. как браузер, так и самописный скрипт-клиент.
*/
public class Server1 {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080))
        {
            System.out.println("Server initialized...");
            while(true) {
                try
                (
                    Socket socket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                )
                {
                    System.out.println("Client connected...");
                    String request = reader.readLine(); //read the request
                    String response = String.format("Your request is: %s", request);
                    Thread.sleep(10000);
                    writer.write(response);
                    writer.newLine();
                    writer.flush(); //clear buffer
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
