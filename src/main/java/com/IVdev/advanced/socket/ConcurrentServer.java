package com.IVdev.advanced.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    Многопоточный сервер демонстрирует одновременное обращение к нему
    нескольких клиентов с различным поведением.
    Инстанс сокета на все приложение нет смысла оборачивать в autocloseable аспект, т.к.
    это приведет к падению reader и/или writer внутри создаваемого потока.
*/
public class ConcurrentServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080))
        {
            System.out.println("Concurrent server initialized...");
            while (true)
                try
                {
                    Socket socket = serverSocket.accept(); //инстанс сокета на все приложение
                    new Thread(() -> {
                        try
                        (
                             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
                        )
                        {
                            System.out.println("Client connected...");
                            String request = reader.readLine(); //read the request

                            String response = String.format("Your request is: %s", request);
                            System.out.println(response);
                            writer.write(response);
                            writer.newLine();
                            writer.flush();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
