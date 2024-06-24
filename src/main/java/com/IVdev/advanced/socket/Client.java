package com.IVdev.advanced.socket;

import java.io.*;
import java.net.Socket;

/*
    Самописный скрипт-клиент.
    В одном потоке нужно четко разграничивать запрос-ответ.
    Вылет из строя и клиента, и сервера ведет к потере передаче данных.
*/
public class Client {
    public static void main(String[] args) throws IOException {
        try
            (
                Socket clientSocket = new Socket("localhost", 8080);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            )
        {
            writer.write("Hello from client!");
            writer.newLine();
            writer.flush();

            for (int i = 0; i < 8; i++) {
                String response = reader.readLine();
                System.out.println(response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
